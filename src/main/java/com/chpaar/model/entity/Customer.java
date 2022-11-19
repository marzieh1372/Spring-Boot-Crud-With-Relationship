package com.chpaar.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Max(500)
    @Column(length = 500)
    private String description;
    @NotBlank
    @Column(nullable = false)
    private String email;
    @Max(100)
    @Column(length = 100)
    private String firstName;
    @Max(100)
    @Column(length = 100)
    private String lastName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet();

}
