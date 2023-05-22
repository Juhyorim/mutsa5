package dev.lime.mutsa5.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="order_item_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "cancellation_id")
  private Cancellation cancellation;

  private String itemName;

  private int price;

  private int count;

  @Enumerated(EnumType.STRING)
  @Column(name = "item_status")
  private ItemStatus status;

}
