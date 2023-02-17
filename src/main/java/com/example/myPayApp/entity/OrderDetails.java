package com.example.myPayApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_details_id",length = 45)
    private int orderDetailsID;
    @Column(name="qty",length = 100,nullable = false)
    private double qty;
    @Column(name="amount",nullable = false)
    private double amount;
    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private Order orders;
    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Items items;

    public OrderDetails(double qty, double amount, Order orders, Items items) {
        this.qty = qty;
        this.amount = amount;
        this.orders = orders;
        this.items = items;
    }
}
