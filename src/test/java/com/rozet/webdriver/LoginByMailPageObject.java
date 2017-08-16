package com.rozet.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginByMailPageObject {
    private ChromeDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/ua/");
    }

    @After
    public void tearDown()    {
        driver.close();
    }

    @Test
    public void LoginByMail(){
        HomePageRozetka home = new HomePageRozetka(driver);
        ResultPageRozetka result = home.login("giftofdestiny@gmail.com");
        assertTrue(result.profile().contains("Иван Дивнич"));
    }

    @Test
    public void LoginByPhone() {
        HomePageRozetka home = new HomePageRozetka(driver);
        ResultPageRozetka result = home.login("+380667607777");
        assertTrue(result.profile().contains("Иван Дивнич"));
    }

    @Test
    public void LoginWithWrongName() {
        HomePageRozetka home = new HomePageRozetka(driver);
        ResultPageRozetka result = home.login("+380667607766");
        assertTrue(result.authorisation().contains("недоступна для авторизації"));
    }


    @Test
    public void TemporaryPass() {
        HomePageRozetka home = new HomePageRozetka(driver);
        ResultPageRozetka result = home.recover("giftofdestiny@gmail.com");
        assertTrue(result.recovermessage().contains("надіслано тимчасовий пароль"));

    }

    @Test
    public void LoginByFacebook() {
        HomePageRozetka home = new HomePageRozetka(driver);
        ResultPageRozetka result = home.facebook();
        assertTrue(result.profile().contains("Stephan James"));
    }
    @Test
    public void LoginAndLogout(){
        HomePageRozetka home = new HomePageRozetka(driver);
        ResultPageRozetka result = home.loginout("giftofdestiny@gmail.com");
        assertTrue(result.userstatus().contains("увійдіть в особистий кабінет"));
    }
}
