package qpassessment.Repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import qpassessment.Model.Order;
import qpassessment.Service.CustomerService;
import qpassessment.dto.OrderItemDto;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    CustomerService service;

    @Test
    @Transactional
    public void save(){
        Integer id = 1000;
        List<OrderItemDto> list = new ArrayList<>();
        list.add(new OrderItemDto(1001,2));
        list.add(new OrderItemDto(1002,2));
        service.save(id,list);
        List<Order> ans = service.getAllOrderByCustomer(id);
        System.out.println(ans.size());

    }
}
