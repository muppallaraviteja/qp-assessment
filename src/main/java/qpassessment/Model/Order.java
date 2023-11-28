package qpassessment.Model;

import jakarta.persistence.*;


import java.util.List;

@Entity(name = "order_details")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Customer customer;
    private Double totalPrice;

    @OneToMany()
    private List<Item> item;

}
