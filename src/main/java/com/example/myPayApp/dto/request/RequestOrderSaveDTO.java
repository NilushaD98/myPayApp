package com.example.myPayApp.dto.request;

import com.example.myPayApp.entity.Customer;
import com.example.myPayApp.entity.OrderDetails;
import com.example.myPayApp.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import com.example.myPayApp.entity.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private String customer;
    private Date date;
    private double total;
    private int paymentMethod;
    private int merchant;
    private int shop;
    private int shopCounter;
    private List<RequestOrderDetailsSaveDTO> requestOrderDetailsSaveDTOList;
}
