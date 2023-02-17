package com.example.myPayApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name="order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    @Column(name="order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name="total", nullable = false)
    private double total;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetailsSet;

    @ManyToOne
    @JoinColumn(name="payment_method_id",nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name="merchant_id",nullable = false)
    private Merchant merchant;

    @ManyToOne
    @JoinColumn(name="shop_id",nullable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "shop_counter_id",nullable = false)
    private ShopCounter shopCounter;

    public Order(Customer customer, Date date, double total, PaymentMethod paymentMethod, Merchant merchant, Shop shop, ShopCounter shopCounter) {
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.merchant = merchant;
        this.shop = shop;
        this.shopCounter = shopCounter;
    }
}
