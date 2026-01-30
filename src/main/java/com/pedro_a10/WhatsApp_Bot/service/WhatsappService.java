package com.pedro_a10.WhatsApp_Bot.service;

import com.pedro_a10.WhatsApp_Bot.util.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

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

    public void sendProduct(String contact, Product product) {
        findContact(contact).click();

        attachImage(product.getImagePath());
        writeCaption(product);
        sendMessage();
    }


    private void attachImage(String imagePath) {
        WebElement attachButton = webDriver.findElement(By.cssSelector("span[data-icon='plus-rounded']"));
        attachButton.click();

        WebElement fileInput = webDriver.findElement(By.cssSelector("input[type='file'][accept*='image']"));
        fileInput.sendKeys(imagePath);
    }

    private void writeCaption(Product product) {
        WebElement captionBox = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@contenteditable='true']")
                ));
        captionBox.sendKeys(
                "Nome: " + product.getNameProduct() +
                        "\n Preço: R$" + product.getPriceProduct() +
                        "\n Quantidade: " + product.getQuantityProduct()
        );
    }

    private void sendMessage() {
        WebElement sendButton = webDriver.findElement(
          By.cssSelector("span[data-icon='wds-ic-send-filled']")
        );
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
