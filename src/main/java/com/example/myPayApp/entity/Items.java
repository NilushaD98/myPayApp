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
@Table(name = "item")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private int itemId;

    @Column(name = "item_name",nullable = false)
    private String itemName;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetailsSet;

    public Items(String itemName) {
        this.itemName = itemName;
    }
}
