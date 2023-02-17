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
@Table(name="counter")
public class ShopCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "counter_id")
    private int counterID;

    @ManyToOne
    @JoinColumn(name="shop_id",nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "shopCounter")
    private Set<Order> orderSet;

}
