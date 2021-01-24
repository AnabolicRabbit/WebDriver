package com.epam.learn.i_can_win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ICanWinSlexyHomePage {

    private static final String HOMEPAGE_URL = "https://slexy.org/";
    private WebDriver driver;

    @FindBy(id = "raw_paste")
    private WebElement codeInput;

    @FindBy(xpath = "//select[@id='expire']")
    private WebElement expirationInput;

    @FindBy(id = "desc")
    private WebElement descriptionInput;

    public ICanWinSlexyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ICanWinSlexyHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("expire")));
        return this;
    }

    public ICanWinSlexyHomePage fillCode(String code) {
        codeInput.sendKeys(code);
        return this;
    }

    public  ICanWinSlexyHomePage fillExpiration(String expiration) {
        expirationInput.sendKeys(expiration);
        Select select = new Select(expirationInput);
        select.selectByVisibleText("15 minutes");
        return this;
    }

    public ICanWinSlexyHomePage fillDescription(String description) {
        descriptionInput.sendKeys(description);
        return this;
    }

}