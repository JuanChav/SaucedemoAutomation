package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpackBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartBtn;

    public void addBackpackToCart(){
        this.waitToBeClickable(this.addToCartBackpackBtn);
        this.addToCartBackpackBtn.click();
    }

    public CartPage clickShoppingCart(){
        this.waitToBeClickable(this.shoppingCartBtn);
        this.shoppingCartBtn.click();
        return new CartPage(this.driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}