package com.pedro_a10.WhatsApp_Bot.service;

import com.pedro_a10.WhatsApp_Bot.repository.ProductRepository;
import com.pedro_a10.WhatsApp_Bot.util.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;

@Slf4j
@Service
public class WhatsappListenerService{

    private String lastMessageRead;
    private String lastMessageFromChat;


    WhatsappService whatsappService;
    WebDriver webDriver;
    ProductRepository productRepository;

    public void read() {
        try {

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
            WebElement contactTitle = webDriver.findElement(By.xpath("//header//span[@dir='auto']"));
            String contact = contactTitle.getText();

            WebElement lastMessage = webDriver.findElement(
                    By.xpath("(//div[contains(@class,'message-in')]//span[@dir='auto'])[last()]")
            );
            lastMessageFromChat = lastMessage.getText();

           if (!lastMessageFromChat.equals(lastMessageRead)){
                String msg = lastMessageFromChat.toLowerCase().trim();
                if (msg.contains("oi") || msg.contains("olá") || msg.contains("opa")) {
                    whatsappService.sendMessage(contact, "Olá! Digite 'produtos' para ver nossos produtos!!");
                } else if (msg.contains("produtos")) {
                    ArrayList<Product> products = new ArrayList<>();

                    products.add(new Product("Box Duna Trilogia com Poster","300,00",1,"C:/Users/pedro/Downloads/WhatsApp_Bot (1)/WhatsApp_Bot/src/main/resources/images/Duna.jpg"));
                    products.add(new Product("Estrutura de dados e Algoritimos em Java","450,00",1,"C:/Users/pedro/Downloads/WhatsApp_Bot (1)/WhatsApp_Bot/src/main/resources/images/Estruturas de Dados e Algoritmos em Java.jpg"));
                    products.add(new Product("Meridiano de sangue (Nova edição)","300,00",1,"C:/Users/pedro/Downloads/WhatsApp_Bot (1)/WhatsApp_Bot/src/main/resources/images/Meridiano de sangue (Nova edição).jpg"));
                    products.add(new Product("Na Terra e no Céu 84 sonetos de amor para Laura","300,00",1,"C:/Users/pedro/Downloads/WhatsApp_Bot (1)/WhatsApp_Bot/src/main/resources/images/Na Terra e no Céu 84 sonetos de amor para Laura .jpg"));

                    whatsappService.sendProducts(contact, products);
                }
           }

           lastMessageRead =lastMessageFromChat;
        } catch (Exception e) {
            log.error("Error: {}", String.valueOf(e));
        }
    }
}