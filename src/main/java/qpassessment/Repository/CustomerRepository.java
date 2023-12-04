package qpassessment.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qpassessment.Model.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
