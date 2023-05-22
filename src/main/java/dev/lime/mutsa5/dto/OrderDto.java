package dev.lime.mutsa5.dto;

import dev.lime.mutsa5.domain.*;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderDto {
  private Long member_id;
  private String orderMemberName;
  private Long orderPrice;
  private List<OrderItemDto> orderItemList;

  @Getter
  public static class OrderItemDto {
    private String itemName;
    private int price;
    private int count;

    public OrderItem toEntity(Order order) {
      return OrderItem.builder()
        .order(order)
        .itemName(itemName)
        .price(price)
        .count(count)
        .build();
    }
  }
}
