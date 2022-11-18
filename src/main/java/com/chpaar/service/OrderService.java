package com.chpaar.service;

import com.chpaar.exceptions.ResourceNotFoundException;
import com.chpaar.model.dto.OrderDto;
import com.chpaar.model.dto.OrderRequest;
import com.chpaar.model.entity.Order;
import com.chpaar.model.mapper.OrderMapper;
import com.chpaar.repo.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderMapper.mapOrderListToOrderDtoList(orderList);
    }

    public OrderDto getOrderById(Long orderId) {
        return orderMapper.mapOrderToOrderDto(findOrderById(orderId));
    }

    private Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("No order found"));
    }

    public OrderDto createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.mapOrderRequestToOrder(orderRequest);
        return orderMapper.mapOrderToOrderDto(orderRepository.save(order));
    }

    public void updateOrder(Long orderId, OrderRequest orderRequest) {
        Order findOrder = findOrderById(orderId);
        findOrder.setCount(orderRequest.getCount());
        orderRepository.save(findOrder);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

}
