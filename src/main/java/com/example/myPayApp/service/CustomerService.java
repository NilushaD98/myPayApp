package com.example.myPayApp.service;

import com.example.myPayApp.dto.request.RequestCustomerDetailsSaveDTO;
import com.example.myPayApp.dto.request.RequestCustomerPhoneNumberSaveDTO;

public interface CustomerService {
    String addCustomer(RequestCustomerDetailsSaveDTO requestCustomerDetailsSaveDTO);

    String addConatctNumber(RequestCustomerPhoneNumberSaveDTO requestCustomerPhoneNumberSaveDTO);

    String deleteCustomer(String customerContact);
}
