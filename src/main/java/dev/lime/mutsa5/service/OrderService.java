package dev.lime.mutsa5.service;

import dev.lime.mutsa5.domain.Member;
import dev.lime.mutsa5.domain.Order;
import dev.lime.mutsa5.domain.OrderItem;
import dev.lime.mutsa5.dto.OrderDto;
import dev.lime.mutsa5.repository.MemberRepository;
import dev.lime.mutsa5.repository.OrderItemRepository;
import dev.lime.mutsa5.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class OrderService {
  private final MemberRepository memberRepository;
  private final OrderItemRepository orderItemRepository;
  private final OrderRepository orderRepository;

  @Transactional
  public Long makeOrder(OrderDto orderDto) throws Exception {
    Member member = memberRepository.findById(orderDto.getMember_id())
      .orElseThrow(() -> new Exception("그런 멤버는 없습니다"));

    Order newOrder = Order.makeOrder(member, orderDto.getOrderMemberName(), orderDto.getOrderPrice());
    orderRepository.save(newOrder);

    for (OrderDto.OrderItemDto dto : orderDto.getOrderItemList()) {
      OrderItem orderItem = dto.toEntity(newOrder);
      orderItemRepository.save(orderItem);
    }

    return newOrder.getId();
  }
}
