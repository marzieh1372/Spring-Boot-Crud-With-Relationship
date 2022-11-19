package com.chpaar.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    @ApiModelProperty(value = "Count", required = true)
    @NotNull(message = "Count can not be null!")
    private Integer count;
    @ApiModelProperty(value = "CustomerId", required = true)
    @NotNull(message = "CustomerId can not be null!")
    private Long customerId;
    @ApiModelProperty(value = "ProductId", required = true)
    @NotNull(message = "ProductId can not be null!")
    private Long productId;
}
