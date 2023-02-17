package com.example.myPayApp.util.mappers;

import com.example.myPayApp.dto.request.RequestCustomerDetailsSaveDTO;
import com.example.myPayApp.dto.request.RequestCustomerPhoneNumberSaveDTO;
import com.example.myPayApp.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer DTOToEntity(RequestCustomerDetailsSaveDTO requestCustomerDetailsSaveDTO);

    Customer DTOToEntityContact(RequestCustomerPhoneNumberSaveDTO requestCustomerPhoneNumberSaveDTO);
}
