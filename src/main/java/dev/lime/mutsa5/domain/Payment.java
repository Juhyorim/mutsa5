package dev.lime.mutsa5.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "order_id")
  private Order order;

  private String paymentMethod;

  private int realPaymentPrice;

  private String paymentStatus;

  private LocalDateTime paymentDateTime;
}
