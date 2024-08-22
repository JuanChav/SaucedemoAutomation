package com.globant.test;

import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void openChromeDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver, "https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closeChromeDriver(){
        driver.quit();
    }
}
