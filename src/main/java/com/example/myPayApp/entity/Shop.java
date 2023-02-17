package com.example.myPayApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.plugin.dom.css.Counter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private int shopID;

    @Column(name = "shop_name",nullable = false)
    private String shopName;

    @Column(name = "shop_address",nullable = false)
    private String shopAddress;
    @ManyToOne
    @JoinColumn(name="merchant_id",nullable = false)
    private Merchant merchant;

    @OneToMany(mappedBy = "shop")
    private Set<ShopCounter> shopCounterSet;

    @OneToMany(mappedBy = "shop")
    private Set<Order> orderSet;
}
