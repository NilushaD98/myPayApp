package com.example.myPayApp.service.serviceIMPL;
import com.example.myPayApp.dto.response.ResponseShopDetailsDTO;
import com.example.myPayApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myPayApp.repo.*;
import com.example.myPayApp.entity.*;
import com.example.myPayApp.util.mappers.*;

@Service
public class ShopServiceIMPL implements ShopService{

    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public ResponseShopDetailsDTO getShopDetails(int shopId) {

        Shop shop = shopRepo.getById(shopId);
        ResponseShopDetailsDTO responseShopDetailsDTO = shopMapper.EntityToDto(shop);
        return responseShopDetailsDTO;
    }
}
