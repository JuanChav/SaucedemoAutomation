package com.globant.test;

import com.globant.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SaucedemoTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

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

        cartPage = homePage.clickShoppingCart();

        checkoutInformationPage = cartPage.clickCheckout();
        checkoutInformationPage.inputFirstName("Juan");
        checkoutInformationPage.inputLastName("Santo Domingo");
        checkoutInformationPage.inputZip(String.valueOf(8001123));

        checkoutOverviewPage = checkoutInformationPage.clickContinue();

        checkoutCompletePage = checkoutOverviewPage.clickFinish();
        softAssert.assertEquals(checkoutCompletePage.getHeaderComplete(), "Thank you for your order!");
        softAssert.assertAll();
    }

    @Test
    public void removingElementsOfTheShoppingCart() {
        homePage.addBackpackToCart();
        homePage.addBikeLightToCart();
        homePage.addBoltTShirtToCart();

        cartPage = homePage.clickShoppingCart();
        cartPage.removeBackpack();
        cartPage.removeBikeLight();
        cartPage.removeBoltTShirt();
        softAssert.assertTrue(cartPage.verifyExistenceOfShoppingCartBadge(), "There is elements in the cart");
        softAssert.assertAll();
    }

    @Test
    public void verifySuccesfullLogout(){
        homePage.clickBurgerMenu();

        loginPage = homePage.clickLogout();
        loginPage.verifyIfLoginBtnIsDisplayed();
    }
}
