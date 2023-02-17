package com.example.myPayApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.myPayApp.service.*;
import com.example.myPayApp.util.*;
import com.example.myPayApp.dto.response.*;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping(path = "api/vi/shop/")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(
            path = {"get_shop_details_by_shop_QR"},
            params = {"shopID"}
    )
    public ResponseEntity<StandardResponse> getShopDetails(@RequestParam(value = "shopID")int shopId){
        ResponseShopDetailsDTO responseShopDetailsDTO = shopService.getShopDetails(shopId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Shop Details : ",responseShopDetailsDTO), HttpStatus.OK
        );
    }

}
