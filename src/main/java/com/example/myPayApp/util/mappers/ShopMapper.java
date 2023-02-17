package com.example.myPayApp.util.mappers;

import com.example.myPayApp.dto.response.ResponseShopDetailsDTO;
import com.example.myPayApp.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    ResponseShopDetailsDTO EntityToDto(Shop shop);
}
