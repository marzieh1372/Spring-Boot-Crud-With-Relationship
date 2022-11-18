package com.chpaar.controller;

import com.chpaar.api.OrderAPI;
import com.chpaar.model.dto.OrderDto;
import com.chpaar.model.dto.OrderRequest;
import com.chpaar.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OrderController implements OrderAPI {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<List<OrderDto>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> createOrder(OrderRequest orderRequest) {
        OrderDto orderDto = orderService.createOrder(orderRequest);
        return new ResponseEntity<OrderDto>(orderDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OrderDto> getOrderById(Long orderId) {
        return new ResponseEntity<OrderDto>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateOrder(Long orderId, OrderRequest orderRequest) {
        orderService.updateOrder(orderId, orderRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
