package com.example.myPayApp.service.serviceIMPL;

import com.example.myPayApp.dto.request.RequestCustomerDetailsSaveDTO;
import com.example.myPayApp.dto.request.RequestCustomerPhoneNumberSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myPayApp.service.*;
import com.example.myPayApp.repo.*;
import com.example.myPayApp.util.mappers.*;
import com.example.myPayApp.entity.*;
import com.example.myPayApp.exceptions.*;

import javax.persistence.EntityNotFoundException;
import java.util.Random;
import java.util.Scanner;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String addCustomer(RequestCustomerDetailsSaveDTO requestCustomerDetailsSaveDTO) {
        if (customerRepo.existsById(requestCustomerDetailsSaveDTO.getContactNumber())){
            Customer customer = customerRepo.getById(requestCustomerDetailsSaveDTO.getContactNumber());
            customer.setCustomerName(requestCustomerDetailsSaveDTO.getCustomerName());
            customer.setCustomerNIC(requestCustomerDetailsSaveDTO.getCustomerNIC());
            customer.setCustomerAddress(requestCustomerDetailsSaveDTO.getCustomerAddress());
            customer.setCustomerEmail(requestCustomerDetailsSaveDTO.getCustomerEmail());
            customer.setCustomerGender(requestCustomerDetailsSaveDTO.getCustomerGender());
            customer.setCustomerPassword(requestCustomerDetailsSaveDTO.getPassword());
            customerRepo.save(customer);
            return "customer "+requestCustomerDetailsSaveDTO.getCustomerName();
        }else {
            throw new EntityNotFoundException("this contact not in database");
        }

    }

    @Override
    public String addConatctNumber(RequestCustomerPhoneNumberSaveDTO requestCustomerPhoneNumberSaveDTO) {
        Customer customer = customerMapper.DTOToEntityContact(requestCustomerPhoneNumberSaveDTO);
        if(!customerRepo.existsById(requestCustomerPhoneNumberSaveDTO.getContactNumber())){

            Random random = new Random();
            int verificationCode = random.nextInt(999999);
            System.out.println(verificationCode);

            Scanner scanner = new Scanner(System.in);
            System.out.println("enter the verification code :");
            int enterdCode = scanner.nextInt();

            if (verificationCode == enterdCode){
                return customerRepo.save(customer).getContactNumber()+" verified.";
            }else {
                while (verificationCode!=enterdCode){
                    System.out.println("verification code wrong, enter the verification code :");
                    enterdCode = scanner.nextInt();
                }
            }
        }else {
            throw  new EntityDuplicationException("this contact already in database");
        }
        return null;
    }

    @Override
    public String deleteCustomer(String customerContact) {
        if (customerRepo.existsById(customerContact)){
            String name  = customerRepo.getById(customerContact).getCustomerName();
            customerRepo.deleteById(customerContact);
            return "customer "+name+" deleted.";
        }else {
            throw new EntityNotFoundException("this customer not in database");
        }
    }
}
