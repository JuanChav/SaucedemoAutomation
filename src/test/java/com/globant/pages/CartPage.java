package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CheckoutInformationPage clickCheckout(){
        this.waitToBeClickable(this.checkoutBtn);
        this.checkoutBtn.click();
        return new CheckoutInformationPage(this.driver);
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
