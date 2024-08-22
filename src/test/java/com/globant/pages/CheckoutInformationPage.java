package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage{
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(css = "input[data-test=\"lastName\"]")
    private WebElement lastNameInput;

    @FindBy(css = "#postal-code")
    private WebElement zipInput;

    @FindBy(xpath = "//input[@name=\"continue\"]")
    private WebElement continueBtn;

    public void inputFirstName(String firstName){
        this.waitElementVisibility(firstNameInput);
        this.firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        this.waitElementVisibility(lastNameInput);
        this.lastNameInput.sendKeys(lastName);
    }

    public void inputZip(String zip){
        this.waitElementVisibility(zipInput);
        this.zipInput.sendKeys(zip);
    }

    public CheckoutOverviewPage clickContinue(){
        this.waitToBeClickable(continueBtn);
        this.continueBtn.click();
        return new CheckoutOverviewPage(this.driver);
    }

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }
}
