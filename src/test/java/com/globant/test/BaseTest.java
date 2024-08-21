package com.globant.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private WebDriver driver;

    @BeforeTest
    public void openChromeDriver(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://www.google.com");
    }

    @AfterTest
    public void closeChromeDriver(){
        driver.quit();
    }
}
