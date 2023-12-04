package qpassessment.Service;

import org.springframework.stereotype.Service;
import qpassessment.Model.OrderItemRequest;
import qpassessment.Repository.OrderItemRequestRepository;

@Service
public class OrderItemRequestService {
    private final OrderItemRequestRepository repository;

    public OrderItemRequestService(OrderItemRequestRepository repository) {
        this.repository = repository;
    }

    public OrderItemRequest save(OrderItemRequest orderItemRequest){
        return repository.save(orderItemRequest);
    }
}
