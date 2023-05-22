package dev.lime.mutsa5.controller;

import dev.lime.mutsa5.dto.OrderDto;
import dev.lime.mutsa5.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {
  private final OrderService orderService;

  @PostMapping("/order")
  public ResponseEntity makeOrder(@RequestBody OrderDto orderDto) throws Exception {
    orderService.makeOrder(orderDto);

    return ResponseEntity.ok().build();
  }
}
