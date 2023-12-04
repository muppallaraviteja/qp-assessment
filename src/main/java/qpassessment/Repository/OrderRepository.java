package qpassessment.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import qpassessment.Model.Order;


@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
