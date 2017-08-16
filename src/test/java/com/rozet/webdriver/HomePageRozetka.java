package com.rozet.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HomePageRozetka {
    private WebDriver driver;

    public HomePageRozetka(ChromeDriver driver) {
        this.driver = driver;
    }




    public ResultPageRozetka login(String user) {
        driver.findElement(By.name("signin")).click();
        driver.findElement(By.name("login")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys("Roccat84!");
        driver.findElement(By.name("auth_submit")).click();

        return new ResultPageRozetka(driver);

    }

    public ResultPageRozetka recover(String mail) {
        driver.findElement(By.name("signin")).click();
        driver.findElement(By.name("forgot_button")).click();
        driver.findElement(By.name("login")).sendKeys(mail);
        driver.findElement(By.name("send_temp_pass_button")).click();

        return new ResultPageRozetka(driver);
    }

    public ResultPageRozetka facebook() {

        driver.findElement(By.name("signin")).click();
        driver.findElement(By.id("social_href_facebook")).click();
        driver.findElement(By.id("email")).sendKeys("ivan.divnich@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("NBA2017");
        driver.findElement(By.id("u_0_0")).click();




        return  new ResultPageRozetka(driver);
    }

    public ResultPageRozetka loginout(String user) {
        driver.findElement(By.name("signin")).click();
        driver.findElement(By.name("login")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys("Roccat84!");
        driver.findElement(By.name("auth_submit")).click();
        driver.findElement(By.xpath("//*[@id=\"header_user_menu_parent\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header_user_menu_parent\"]/a")).click();
        driver.findElement(By.id("profile_signout")).click();


        return new ResultPageRozetka(driver);
    }
}
