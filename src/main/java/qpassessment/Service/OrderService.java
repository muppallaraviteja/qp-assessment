package qpassessment.Service;

import org.springframework.stereotype.Service;
import qpassessment.Model.Order;
import qpassessment.Repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order save(Order order){
        return repository.save(order);
    }

}
