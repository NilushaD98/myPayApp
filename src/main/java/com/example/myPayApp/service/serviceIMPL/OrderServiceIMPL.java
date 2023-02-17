package com.example.myPayApp.service.serviceIMPL;
import com.example.myPayApp.dto.request.RequestOrderSaveDTO;
import com.example.myPayApp.dto.response.ResponsePaymentHistoryDTO;
import com.example.myPayApp.service.*;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.myPayApp.repo.*;
import com.example.myPayApp.entity.*;
import com.example.myPayApp.util.mappers.*;
import org.modelmapper.ModelMapper;
import com.example.myPayApp.dto.QueryInterfaces.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService{

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private MerchantRepo merchantRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private ShopCounterRepo shopCounterRepo;;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private PaymentMethodRepo paymentMethodRepo;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal(),
                paymentMethodRepo.getById(requestOrderSaveDTO.getPaymentMethod()),
                merchantRepo.getById(requestOrderSaveDTO.getMerchant()),
                shopRepo.getById(requestOrderSaveDTO.getShop()),
                shopCounterRepo.getById(requestOrderSaveDTO.getShop())
        );
        orderRepo.save(order);
        System.out.println("Payment Successful. ");
        System.out.println("Date : "+ requestOrderSaveDTO.getDate());
        System.out.println("Merchant : "+ merchantRepo.getById(requestOrderSaveDTO.getMerchant()).getMerchantName());
        System.out.println("Amount : " + requestOrderSaveDTO.getTotal() );
        if(orderRepo.existsById(order.getOrderID())){
            List<OrderDetails> orderDetailsList =
                    modelMapper
                            .map(requestOrderSaveDTO.getRequestOrderDetailsSaveDTOList(), new TypeToken<List<OrderDetails>>() {
                            }.getType());

            if(orderDetailsList.size()>0){
                for(int i=0;i<orderDetailsList.size();i++){
                    orderDetailsList.get(i).setOrders(order);
                    orderDetailsList.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getRequestOrderDetailsSaveDTOList().get(i).getItem()));
                }
                orderDetailsRepo.saveAll(orderDetailsList);
                return order.getOrderID() + " saved";
            }
        }else {
            throw new EntityNotFoundException("order not saved");
        }
        return null;
    }

    @Override
    public List<ResponsePaymentHistoryDTO> getPaymentDetails() {

        List<PaymentHistoryInterface> paymentHistoryInterfaceList = orderRepo.getAllPaymentDetails();

        List<ResponsePaymentHistoryDTO> list = new ArrayList<>();
        for (PaymentHistoryInterface o: paymentHistoryInterfaceList) {
            ResponsePaymentHistoryDTO responsePaymentHistoryDTO = new ResponsePaymentHistoryDTO(
                    o.getPaymentMethodID(),o.getCustomerName(),o.getDate(),o.getTotal()
            );
            list.add(responsePaymentHistoryDTO);
        }
        return list;
    }
}
