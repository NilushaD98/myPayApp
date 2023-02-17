package com.example.myPayApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentMethodDTO {

    private int paymentMethodID;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
}
