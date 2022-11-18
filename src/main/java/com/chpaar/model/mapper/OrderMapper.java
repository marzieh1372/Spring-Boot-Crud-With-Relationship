package com.chpaar.model.mapper;

import com.chpaar.model.dto.OrderDto;
import com.chpaar.model.dto.OrderRequest;
import com.chpaar.model.entity.Customer;
import com.chpaar.model.entity.Order;
import com.chpaar.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    public List<OrderDto> mapOrderListToOrderDtoList(List<Order> orderList){
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order: orderList){
            OrderDto orderDto=OrderDto.builder()
                    .count(order.getCount())
                    .customerId(order.getCustomer().getId())
                    .productId(order.getProduct().getId())
                    .id(order.getId())
                    .build();
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }


    public OrderDto mapOrderToOrderDto(Order order){
        return OrderDto.builder()
                .count(order.getCount())
                .customerId(order.getCustomer().getId())
                .productId(order.getProduct().getId())
                .id(order.getId())
                .build();
    }


    public  Order mapOrderRequestToOrder(OrderRequest orderRequest){
       return Order.builder()
                .count(orderRequest.getCount())
                .customer(Customer.builder().id(orderRequest.getCustomerId()).build())
                .product(Product.builder().id(orderRequest.getProductId()).build())
                .build();
    }
}
