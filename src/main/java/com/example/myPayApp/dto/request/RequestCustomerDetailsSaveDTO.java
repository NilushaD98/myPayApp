package com.example.myPayApp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCustomerDetailsSaveDTO {

    private String contactNumber;
    private String customerName;
    private String password;
    private String customerNIC;
    private String customerGender;
    private String customerEmail;
    private String customerAddress;
}
