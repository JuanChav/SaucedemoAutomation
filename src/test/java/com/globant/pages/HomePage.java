package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartBtn;

    @FindAll(@FindBy(className = "btn_inventory"))
    private List<WebElement> addToCartBtn;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(css = "#logout_sidebar_link")
    private WebElement logoutBtn;

    public CartPage clickShoppingCart(){
        this.waitToBeClickable(this.shoppingCartBtn);
        this.shoppingCartBtn.click();
        return new CartPage(this.driver);
    }

    public void clickAddToCart(){
        int randomIndex = new Random().nextInt(this.addToCartBtn.size());
        WebElement randomElement = addToCartBtn.get(randomIndex);
        randomElement.click();
    }

    public void clickAddToCartThreeTimes(){
        List<WebElement> randomElements = new ArrayList<>(this.addToCartBtn);

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(randomElements.size());
            WebElement randomElement = randomElements.get(randomIndex);

            randomElement.click();

            randomElements.remove(randomIndex);
        }
    }

    public void clickBurgerMenu(){
        this.waitToBeClickable(this.burgerMenuBtn);
        this.burgerMenuBtn.click();
    }

    public LoginPage clickLogout(){
        this.waitToBeClickable(this.logoutBtn);
        this.logoutBtn.click();
        return new LoginPage(this.driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Isn't use cause randomize, other ways to use locators
    /*@FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackpackBtn;

    @FindBy(css = "button[data-test=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement addToCartBikeLightBtn;

    @FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement addToCartBoltTShirtBtn;

    public void addBackpackToCart(){
        this.waitToBeClickable(this.addToCartBackpackBtn);
        this.addToCartBackpackBtn.click();
    }

    public void addBikeLightToCart(){
        this.waitToBeClickable(this.addToCartBikeLightBtn);
        this.addToCartBikeLightBtn.click();
    }

    public void addBoltTShirtToCart(){
        this.waitToBeClickable(this.addToCartBoltTShirtBtn);
        this.addToCartBoltTShirtBtn.click();
    }*/
}