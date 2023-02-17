package com.example.myPayApp.service.serviceIMPL;
import com.example.myPayApp.dto.request.RequestPaymentMethodSaveDTO;
import com.example.myPayApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.myPayApp.repo.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.myPayApp.entity.*;
import com.example.myPayApp.exceptions.*;

import javax.persistence.EntityNotFoundException;

@Service
public class PaymentMethodServiceIMPL implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepo paymentMethodRepo;

    @Autowired
    private CustomerRepo customerRepo;
    PasswordEncoder passwordEncoder;

    public PaymentMethodServiceIMPL() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String savePaymentMethod(RequestPaymentMethodSaveDTO requestPaymentMethodSaveDTO) {
        PaymentMethod paymentMethod = new PaymentMethod(
                passwordEncoder.encode(requestPaymentMethodSaveDTO.getCardNumber()),
                passwordEncoder.encode(requestPaymentMethodSaveDTO.getExpireYear()),
                passwordEncoder.encode(requestPaymentMethodSaveDTO.getExpireMonth()),
                passwordEncoder.encode(requestPaymentMethodSaveDTO.getCvc()),
                customerRepo.getById(requestPaymentMethodSaveDTO.getContactNumber())
        );


        if (!paymentMethodRepo.existsById(paymentMethod.getPaymentMethodID())) {
            return "saved payment method ID: " + paymentMethodRepo.save(paymentMethod).getPaymentMethodID();
        } else {
            throw new EntityDuplicationException("this card already in database");
        }
    }

    @Override
    public String deletePaymentMethod(int paymentMethodId) {
        if(paymentMethodRepo.existsById(paymentMethodId)){
            int x = paymentMethodId;
            paymentMethodRepo.deleteById(paymentMethodId);
            return "payment method " +x+ " deleted";
        }else {
            throw new EntityNotFoundException("this payment method not in database");
        }
    }
}
