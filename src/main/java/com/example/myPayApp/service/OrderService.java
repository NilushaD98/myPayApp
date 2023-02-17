package com.example.myPayApp.service;

import com.example.myPayApp.dto.request.RequestOrderSaveDTO;
import com.example.myPayApp.dto.response.ResponsePaymentHistoryDTO;

import java.util.List;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    List<ResponsePaymentHistoryDTO> getPaymentDetails();
}
