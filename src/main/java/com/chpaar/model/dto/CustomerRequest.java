package com.chpaar.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String description;
}
