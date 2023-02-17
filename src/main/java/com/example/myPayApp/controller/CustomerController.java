package com.example.myPayApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.myPayApp.service.*;
import com.example.myPayApp.util.*;
import com.example.myPayApp.dto.request.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(
            path = "verify_customer_contact"
    )
    public ResponseEntity<StandardResponse> addCustomerContact(@RequestBody RequestCustomerPhoneNumberSaveDTO requestCustomerPhoneNumberSaveDTO){
        String contactveriffyStatus = customerService.addConatctNumber(requestCustomerPhoneNumberSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Contact verify status", contactveriffyStatus),HttpStatus.OK
        );
    }
    @PostMapping(
            path = "customer_details_save"
    )
    public ResponseEntity<StandardResponse> saveCustomerDetails(@RequestBody RequestCustomerDetailsSaveDTO requestCustomerDetailsSaveDTO){
        String savedStatus = customerService.addCustomer(requestCustomerDetailsSaveDTO)+" saved";
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"customer details saved status : ",savedStatus), HttpStatus.OK
        );
    }
    @PutMapping(
            path = "customer_details_update"
    )
    public ResponseEntity<StandardResponse> updateCustomerDetails(@RequestBody RequestCustomerDetailsSaveDTO requestCustomerDetailsSaveDTO){
        String updateStatus = customerService.addCustomer(requestCustomerDetailsSaveDTO)+" updated";
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"customer details updated status : ",updateStatus), HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = {"customer_delete"},
            params = {"customer_contact"}
    )
    public ResponseEntity<StandardResponse> deleteCustomer(
            @RequestParam(value = "customer_contact")String customerContact
            )
    {
        String deleteStatus = customerService.deleteCustomer(customerContact);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"customer delete status : ",deleteStatus),HttpStatus.OK
        );
    }
}