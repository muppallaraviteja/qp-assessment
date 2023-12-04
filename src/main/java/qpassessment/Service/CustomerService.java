package qpassessment.Service;

import org.springframework.stereotype.Service;
import qpassessment.Exception.InventoryCountExceededException;
import qpassessment.Exception.ResourceNotFoundException;
import qpassessment.Model.Customer;
import qpassessment.Model.Item;

import qpassessment.Model.Order;
import qpassessment.Model.OrderItemRequest;
import qpassessment.Repository.CustomerRepository;
import qpassessment.dto.OrderItemDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private final OrderItemRequestService orderItemRequestService;
    private final ItemService itemService;

    public CustomerService(CustomerRepository customerRepository, OrderService orderService, OrderItemRequestService orderItemRequestService, ItemService itemService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
        this.orderItemRequestService = orderItemRequestService;
        this.itemService = itemService;
    }

    public List<Customer> listAllCustomers(){
        return customerRepository.findAll();
    }


    public Customer listCustomerById(Integer id){
        Optional<Customer> option =  customerRepository.findById(id);
        if(option.isEmpty())
            throw new ResourceNotFoundException("Item "+id+" not found");
        return option.get();
    }

    public List<Order> getAllOrderByCustomer(Integer id) {
        Customer customer  = listCustomerById(id);
        return customer.getOrders();
    }


    public Order save(Integer id, List<OrderItemDto> orderItemDtos) {
        Customer customer  = listCustomerById(id);
        Order order = new Order();
        order.setCustomer(customer);
        order = orderService.save(order);
        List<OrderItemRequest>  list = new ArrayList<>();
        for(OrderItemDto obj: orderItemDtos){
            Item item  = itemService.listItemById(obj.getItemId());
            if(obj.getQuantity()>item.getInventory())
                throw new InventoryCountExceededException("Inventory  Item "+ id+ " not present. Please try later");
            OrderItemRequest req = new OrderItemRequest(order,item,obj.getQuantity());
            OrderItemRequest x = orderItemRequestService.save(req);
            list.add(x);

        }
        order.setCustomer(customer);
        order.setOrderItemRequests(list);
        return orderService.save(order);

    }
}
