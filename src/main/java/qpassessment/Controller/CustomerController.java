package qpassessment.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import qpassessment.Model.Customer;
import qpassessment.Model.Item;
import qpassessment.Model.Order;
import qpassessment.Model.OrderItemRequest;
import qpassessment.Service.CustomerService;
import qpassessment.dto.OrderItemDto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customer")
    public List<Customer> findAllCustomers(){
        return service.listAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getItemById(@PathVariable Integer id){
        return service.listCustomerById(id);
    }

    @GetMapping("/customer/order/{id}")
    public List<Order> getAllOrdersByCustomerId(@PathVariable Integer id){
       return  service.getAllOrderByCustomer(id);

    }



    @PostMapping("/customer/order/{id}")
    public ResponseEntity<Object> orderItems(@PathVariable Integer id, @RequestBody List<OrderItemDto> orderItemDtos){
        Order order =  service.save(id, orderItemDtos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


}
