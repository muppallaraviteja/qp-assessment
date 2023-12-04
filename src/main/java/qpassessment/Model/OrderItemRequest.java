package qpassessment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class OrderItemRequest {
    @EmbeddedId
    @JsonIgnore
    private OrderItemPK pk;

    @Column(nullable = false)
    private Integer quantity;



    // default constructor

    public OrderItemRequest(Order order, Item item, Integer quantity) {
        pk = new OrderItemPK();
        pk.setOrder(order);
        pk.setItem(item);
        this.quantity = quantity;
    }

    public OrderItemRequest() {
    }

    @Transient
    public Item getItem() {
        return this.pk.getItem();
    }

    @Transient
    public Double getTotalPrice() {
        return getItem().getPrice() * getQuantity();
    }


    public OrderItemPK getPk() {
        return pk;
    }

    public void setPk(OrderItemPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderItemRequest other = (OrderItemRequest) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }

}
