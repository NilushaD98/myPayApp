package com.example.myPayApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.myPayApp.entity.*;

@Repository
@EnableJpaRepositories
public interface ShopRepo extends JpaRepository<Shop,Integer> {
}
