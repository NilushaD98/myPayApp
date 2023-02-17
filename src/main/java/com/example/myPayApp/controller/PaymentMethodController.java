package com.example.myPayApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.myPayApp.service.*;
import com.example.myPayApp.util.*;
import com.example.myPayApp.dto.request.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1/paymentMethod/")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping(
            path = "save_payment_method"
    )
    public ResponseEntity<StandardResponse> addPaymentMethod(@RequestBody RequestPaymentMethodSaveDTO requestPaymentMethodSaveDTO){
        String paymentMethodSavedStatus = paymentMethodService.savePaymentMethod(requestPaymentMethodSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Payment Method Saved Status : ",paymentMethodSavedStatus), HttpStatus.OK
        );
    }
    @DeleteMapping(
            path = ("delete_payment_method"),
            params = {"payment_id"}

    )
    public ResponseEntity<StandardResponse> deletePaymentMethod(
            @RequestParam(value = "payment_id")int paymentMethodId
    ){
        String paymentMethodDeleteStatus = paymentMethodService.deletePaymentMethod(paymentMethodId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"payment method delete status :",paymentMethodDeleteStatus),HttpStatus.OK
        );
    }


}
