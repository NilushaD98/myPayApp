package com.example.myPayApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @Column(name = "payment_method_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentMethodID;

    @Column(name="cardNumber")
    private String cardNumber;

    @Column(name = "expire_year")
    private String expireYear;

    @Column(name = "expire_month")
    private String expireMonth;

    @Column(name="cvc")
    private String cvc;

    @OneToMany(mappedBy = "paymentMethod")
    private Set<Order> orderSet;
    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    public PaymentMethod(String cardNumber, String expireYear, String expireMonth, String cvc, Customer customer) {
        this.cardNumber = cardNumber;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
        this.cvc = cvc;
        this.customer = customer;
    }
}
