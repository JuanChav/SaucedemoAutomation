package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackBtn;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeBikeLightBtn;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement removeBoltTShirtBtn;

    @FindAll(@FindBy(className = "shopping_cart_badge"))
    private List<WebElement> shoppingCartBadgeTxt;

    public CheckoutInformationPage clickCheckout(){
        this.waitToBeClickable(this.checkoutBtn);
        this.checkoutBtn.click();
        return new CheckoutInformationPage(this.driver);
    }

    public void removeBackpack(){
        this.waitToBeClickable(this.removeBackpackBtn);
        this.removeBackpackBtn.click();
    }

    public void removeBikeLight(){
        this.waitToBeClickable(this.removeBikeLightBtn);
        this.removeBikeLightBtn.click();
    }

    public void removeBoltTShirt(){
        this.waitToBeClickable(this.removeBoltTShirtBtn);
        this.removeBoltTShirtBtn.click();
    }

    public Boolean verifyExistenceOfShoppingCartBadge(){
        return this.shoppingCartBadgeTxt.isEmpty();
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
