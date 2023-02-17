package com.example.myPayApp.service;

import com.example.myPayApp.dto.response.ResponseShopDetailsDTO;

public interface ShopService {
    ResponseShopDetailsDTO getShopDetails(int shopId);
}
