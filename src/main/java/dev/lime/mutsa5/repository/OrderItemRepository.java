package dev.lime.mutsa5.repository;

import dev.lime.mutsa5.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
