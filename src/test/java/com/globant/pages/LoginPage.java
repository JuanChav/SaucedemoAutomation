package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(className = "submit-button")
    private WebElement submitBtn;

    public void inputUsername(String username){
        this.usernameInput.sendKeys(username);
    }

    public void inputPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        this.submitBtn.click();
    }

    public LoginPage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
    }
}
