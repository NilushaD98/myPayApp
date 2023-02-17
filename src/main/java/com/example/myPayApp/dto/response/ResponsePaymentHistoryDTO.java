package com.example.myPayApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePaymentHistoryDTO {

    private int paymentMethodID;
    private String customerName;
    private Date date;
    private double total;

}
