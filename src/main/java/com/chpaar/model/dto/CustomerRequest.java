package com.chpaar.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    @ApiModelProperty(value = "Email", required = true)
    @NotBlank(message = "Email can not be null or empty! ")
    private String email;
    @ApiModelProperty(value = "FirstName", required = false)
    private String firstName;
    @ApiModelProperty(value = "LastName", required = false)
    private String lastName;
    @ApiModelProperty(value = "Description", required = false)
    @Size(min = 0, max = 500, message = "Max size for description is 500 character")
    private String description;
}
