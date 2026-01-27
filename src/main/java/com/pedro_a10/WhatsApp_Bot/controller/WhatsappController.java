package com.pedro_a10.WhatsApp_Bot.controller;

import com.pedro_a10.WhatsApp_Bot.service.WhatsappService;
import com.pedro_a10.WhatsApp_Bot.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zap")
@Slf4j
public class WhatsappController {

    @Autowired
    WhatsappService whatsappService;

    @PostMapping
    public void receiveMessage(@RequestBody Message message) {
        for (String contact : message.getMessage()) {
            try {
                whatsappService.sendMessage(contact, message.getContent());
            } catch (Exception e) {
                log.error("Error sending to {}", contact, e);
            }
        }
    }
}
