package dev.lime.mutsa5.domain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @Column(name = "order_member_id")
  private String orderMemberName;

  private Long orderPrice;

  @Enumerated(EnumType.STRING)
  @Column(name = "order_status")
  private OrderStatus status;

  @CreationTimestamp
  private LocalDateTime dateTime;

  public static Order makeOrder(Member member, String orderMemberName, Long orderPrice) {
    Order order = new Order();
    order.member = member;
    order.orderMemberName = orderMemberName;
    order.orderPrice = orderPrice;
    return order;
  }


}
