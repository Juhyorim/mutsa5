package dev.lime.mutsa5.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cancellation {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cancellation_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  private int cancelPrice;

  private String cancelStatus;

  @Column(name = "cancel_date_time")
  private LocalDateTime cancelDateTime;
}
