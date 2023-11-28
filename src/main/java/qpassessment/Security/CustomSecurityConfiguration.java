package qpassessment.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@Configuration
@EnableMethodSecurity(jsr250Enabled = true,securedEnabled = true)
public class CustomSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(s->s
                .requestMatchers(AntPathRequestMatcher.antMatcher("/customer")).hasRole("ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/customer/paging")).hasRole("USER")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/hello")).permitAll()
                .anyRequest().authenticated());

        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(s->s.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource,BCryptPasswordEncoder encoder){
        /*UserDetailsManager manager = new InMemoryUserDetailsManager();*/
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        UserDetails user1 = User.builder().username("admin").password("admin").passwordEncoder(encoder::encode).roles("ADMIN","USER").build();
        UserDetails user2 = User.builder().username("user").password("user").passwordEncoder(encoder::encode).roles("USER").build();
        UserDetails user3 = User.builder().username("tester").password("tester").passwordEncoder(encoder::encode).roles("TESTER").build();
        manager.createUser(user1);
        manager.createUser(user2);
        manager.createUser(user3);
        return manager;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("*");
            }
        };

    }

    @Bean
    public DataSource dataSource(){
      return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder(6);
    }
}
