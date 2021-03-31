package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver webDriver;

    @BeforeMethod
    public void StartUp(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriverManager.chromedriver().setup();


        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        webDriver.get("https://www.trendyol.com/");
        webDriver.findElement(By.className("fancybox-close")).click();

    }
    /*@AfterMethod
    public void tearDown(){
        webDriver.quit();
    }*/
}
