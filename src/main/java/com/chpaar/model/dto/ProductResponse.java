package com.chpaar.model.dto;

import com.chpaar.model.entity.Order;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private Double price;
    private String name;
    private List<OrderResponse> orders;
}
