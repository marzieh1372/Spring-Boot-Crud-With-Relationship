package com.chpaar.model.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String description;
    private List<OrderResponse> orders;
}
