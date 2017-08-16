package com.rozet.webdriver;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyFirstTest {

    @Test

    public void startWebDriver() {


        System.setProperty("webdriver.chrome.driver", "E:/rozetka/src/test/java/com/rozet/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://rozetka.com.ua");
        WebElement signin = driver.findElement(By.name("signin"));
        signin.click();

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("giftofdestiny@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Roccat84!");

        WebElement autorization =  driver.findElement(By.name("auth_submit"));
        autorization.click();



        }


    }








