package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(id = "finish")
    private WebElement finishBtn;

    public CheckoutCompletePage clickFinish(){
        this.waitToBeClickable(finishBtn);
        this.finishBtn.click();
        return new CheckoutCompletePage(this.driver);
    }

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
}
