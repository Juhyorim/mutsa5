package dev.lime.mutsa5.repository;

import dev.lime.mutsa5.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
