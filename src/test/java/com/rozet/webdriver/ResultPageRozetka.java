package com.rozet.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPageRozetka {
    private final WebDriver driver;

    public ResultPageRozetka(WebDriver driver) {
        this.driver = driver;
    }

    public String profile() {


        return driver.findElement(By.name("profile")).getText();
    }


    public String authorisation() {
        return driver.findElement(By.name("email_hint")).getText();
    }

    public String  recovermessage() {
        return driver.findElement(By.name("email_hint")).getText();
    }

    public String userstatus() {
        return driver.findElement(By.name("signin")).getText();
    }
}
