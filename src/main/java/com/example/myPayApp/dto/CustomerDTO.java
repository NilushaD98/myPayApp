package com.example.myPayApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private String contactNumber;
    private String customerName;
    private String password;
    private String customerNIC;
    private String customerGender;
    private String customerEmail;
    private String customerAddress;
}
