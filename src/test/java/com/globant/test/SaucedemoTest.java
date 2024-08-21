package com.globant.test;

import com.globant.pages.HomePage;
import com.globant.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SaucedemoTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void verifySuccesfullLogin() {
        loginPage = getLoginPage();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");

        homePage = loginPage.clickSubmit();
    }

    @Test
    public void purchaseAProduct() {
        homePage.addBackpackToCart();
        homePage.clickShoppingCart();
    }

}
