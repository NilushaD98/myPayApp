package com.example.myPayApp.service;

import com.example.myPayApp.dto.request.RequestPaymentMethodSaveDTO;

public interface PaymentMethodService {
    String savePaymentMethod(RequestPaymentMethodSaveDTO requestPaymentMethodSaveDTO);


    String deletePaymentMethod(int paymentMethodId);
}
