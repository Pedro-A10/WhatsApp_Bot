package com.pedro_a10.WhatsApp_Bot.repository;

import com.pedro_a10.WhatsApp_Bot.util.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameProductContainingIgnoreCase(String nome);
}
