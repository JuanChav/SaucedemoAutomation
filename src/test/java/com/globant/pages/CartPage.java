package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindAll(@FindBy(className = "shopping_cart_badge"))
    private List<WebElement> shoppingCartBadgeTxt;

    @FindAll(@FindBy(css = ".btn_small"))
    private List<WebElement> removeInCartBtn;

    public CheckoutInformationPage clickCheckout(){
        this.waitToBeClickable(this.checkoutBtn);
        this.checkoutBtn.click();
        return new CheckoutInformationPage(this.driver);
    }

    public void removeInCart(){
        for (WebElement element : removeInCartBtn){
            element.click();
        }
    }

    public Boolean verifyExistenceOfShoppingCartBadge(){
        return this.shoppingCartBadgeTxt.isEmpty();
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Isn't use cause randomize, other ways to use locators
    /*@FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackBtn;

    @FindBy(css = "#remove-sauce-labs-bike-light")
    private WebElement removeBikeLightBtn;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement removeBoltTShirtBtn;

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
    }*/
}
