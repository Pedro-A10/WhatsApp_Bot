package com.pedro_a10.WhatsApp_Bot;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class WhatsAppBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsAppBotApplication.class, args);
	}

	@Bean
	public WebDriver webDriver() {
		log.info("Instantiating");
		ChromeOptions options = new ChromeOptions();
		var webDriver = new ChromeDriver(options);
		webDriver.get("https://web.whatsapp.com/");
		return webDriver;
	}

}
