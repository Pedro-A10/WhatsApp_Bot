package com.pedro_a10.WhatsApp_Bot.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WhatsappService {

    @Autowired
    private WebDriver webDriver;

    public void sendMessage(String contact, String text) {
        findContact(contact).click();

        WebElement textBox = findTextBox();
        textBox.sendKeys(text);
        textBox.sendKeys(Keys.RETURN);
    }

    private WebElement findContact(String contactName) {
        var xPathContact = "//*[@id=\"pane-side\"]/*//span[@title='" + contactName + "']";
        return webDriver.findElement(By.xpath(xPathContact));
    }

    private WebElement findTextBox() {
        var xPathTextBox = "//*[@id=\"main\"]/footer//*[@role='textbox']";
        return webDriver.findElement(By.xpath(xPathTextBox));
    }
}
