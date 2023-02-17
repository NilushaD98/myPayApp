package com.example.myPayApp.repo;

import com.example.myPayApp.dto.QueryInterfaces.PaymentHistoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.myPayApp.entity.*;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer> {
    @Query(value ="select payment_methods.payment_method_id, customer.customer_name, orders.order_data, orders.total from customer INNER JOIN payment_methods ON payment_methods.customer_id= customer.contact_number INNER JOIN orders ON orders.customer_id = customer.contact_number;",nativeQuery = true)
    List<PaymentHistoryInterface> getAllPaymentDetails();
}
