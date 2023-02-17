package com.example.myPayApp.dto.QueryInterfaces;

import java.util.Date;

public interface PaymentHistoryInterface {
     int getPaymentMethodID();
     String getCustomerName();
     Date getDate();
     double getTotal();

}
