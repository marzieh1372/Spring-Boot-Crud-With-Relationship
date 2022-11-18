package com.chpaar.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Double price;
    @Column
    private String name;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet();
}
