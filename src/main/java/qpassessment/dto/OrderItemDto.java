package qpassessment.dto;


import qpassessment.Model.Item;

public class OrderItemDto {

    private Integer itemId;
    private Integer quantity;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItemDto() {
    }

    public OrderItemDto(Integer itemId, Integer quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
