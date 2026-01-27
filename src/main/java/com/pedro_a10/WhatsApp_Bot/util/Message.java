package com.pedro_a10.WhatsApp_Bot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
    private Set<String> message;
    private String content;
}
