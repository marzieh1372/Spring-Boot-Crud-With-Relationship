package com.chpaar.model.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    private Integer count;
    private Long customerId;
    private Long productId;
}
