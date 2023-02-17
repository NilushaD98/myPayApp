package com.example.myPayApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name = "contactNumber",length = 10)
    private String contactNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet;

    @OneToMany(mappedBy = "customer")
    private Set<PaymentMethod> paymentMethodSet ;

    @Column(name = "customer_name",length = 100)
    private String customerName;

    @Column(name = "customer_password",length = 8)
    private String customerPassword;

    @Column(name = "customer_nic",length = 12)
    private String customerNIC;

    @Column(name = "customer_gender")
    private String customerGender;

    @Column(name = "customer_email",unique = true)
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;



    public Customer(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Customer(String customerName, String customerPassword, String customerNIC, String customerGender, String customerEmail, String customerAddress) {
        this.customerName = customerName;
        this.customerPassword = customerPassword;
        this.customerNIC = customerNIC;
        this.customerGender = customerGender;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }
}
