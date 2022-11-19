package com.chpaar.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @ApiModelProperty(value = "Price", required = true)
    @NotNull(message = "Price can not be null! ")
    private Double price;
    @ApiModelProperty(value = "Name", required = true)
    @NotBlank(message = "Name can not be null or empty! ")
    private String name;

}
