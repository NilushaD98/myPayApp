package com.example.myPayApp.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.myPayApp.service.*;
import com.example.myPayApp.util.*;
import com.example.myPayApp.dto.request.*;
import com.example.myPayApp.dto.response.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(
            path = {"order_save"}
    )
    public ResponseEntity<StandardResponse> orderSave(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String orderSaveStatus = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Order save Status : ",orderSaveStatus), HttpStatus.OK
        );
    }
    @GetMapping(
            path ={"get_payment_details"}
    )
    public ResponseEntity<StandardResponse> getPaymentDetails(){
        List<ResponsePaymentHistoryDTO> responsePaymentHistoryDTOList = orderService.getPaymentDetails();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Payment Details : ",responsePaymentHistoryDTOList),HttpStatus.OK
        );
    }
}
