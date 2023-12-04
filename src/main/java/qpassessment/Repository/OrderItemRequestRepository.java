package qpassessment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qpassessment.Model.OrderItemPK;
import qpassessment.Model.OrderItemRequest;

public interface OrderItemRequestRepository extends JpaRepository<OrderItemRequest, OrderItemPK> {
}
