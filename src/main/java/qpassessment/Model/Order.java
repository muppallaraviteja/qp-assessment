package qpassessment.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="orderItemRequests")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;


    @OneToMany(mappedBy = "pk.order")
    private List<OrderItemRequest> orderItemRequests;

    public Order(Integer id, Customer customer, List<OrderItemRequest> orderItemRequests) {
        this.id = id;
        this.customer = customer;
        this.orderItemRequests = orderItemRequests;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItemRequest> getOrderItemRequests() {
        return orderItemRequests;
    }

    public void setOrderItemRequests(List<OrderItemRequest> orderItemRequests) {
        this.orderItemRequests = orderItemRequests;
    }

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderItemRequest> orderItemRequestList = getOrderItemRequests();
        for (OrderItemRequest op : orderItemRequestList) {
            sum += op.getTotalPrice();
        }

        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderItemRequests.size();
    }
}
