package com.example.myPayApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "merchant_id")
    private int merchantId;

    @Column(name = "merchant_name",nullable = false)
    private String merchantName;

    @OneToMany(mappedBy = "merchant")
    private Set<Shop> shopSet;

    @OneToMany(mappedBy = "merchant")
    private Set<Order> orderSet;

}
