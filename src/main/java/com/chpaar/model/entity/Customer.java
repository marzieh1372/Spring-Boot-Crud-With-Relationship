package com.chpaar.model.entity;


import lombok.*;

import javax.persistence.*;
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
    @Column
    private String description;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet();

}
