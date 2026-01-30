package com.pedro_a10.WhatsApp_Bot.util;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "products")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private String nameProduct;
    private String priceProduct;
    private int quantityProduct;
    private String imagePath;
}
