package com.example.myPayApp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.myPayApp.entity.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPaymentMethodSaveDTO {
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private String contactNumber;
}
