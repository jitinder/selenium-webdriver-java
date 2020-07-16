package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/animal");

        WebElement animalField = driver.findElement(By.id("animalText"));
        animalField.sendKeys("Lion");

        WebElement adjField = driver.findElement(By.id("adjective"));
        adjField.sendKeys("Roaring");

        for(int i = 0; i < 5; i++) {
            WebElement submitButton = driver.findElement(By.id("submitForm"));
            submitButton.click();
            Thread.sleep(2000);
        }

        WebElement concMessage = driver.findElement(By.className("conclusionMessage"));
        System.out.println(concMessage.getText());

        Thread.sleep(5000);
        driver.close();
    }
}
