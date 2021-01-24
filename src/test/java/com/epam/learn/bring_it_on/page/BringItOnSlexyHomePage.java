package com.epam.learn.bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BringItOnSlexyHomePage {

    private static final String HOMEPAGE_URL = "https://slexy.org/";
    private WebDriver driver;

    @FindBy(id = "raw_paste")
    private WebElement codeInput;

    @FindBy(xpath = "//select[@id='lang']")
    private WebElement languageInput;

    @FindBy(xpath = "//select[@id='expire']")
    private WebElement expirationInput;

    @FindBy(id = "desc")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@value='Create Paste']")
    private WebElement saveButton;

    public BringItOnSlexyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("expire")));
    }

    public void fillCode(String code) {
        codeInput.sendKeys(code);
    }

    public void fillLanguage(String language) {
        languageInput.sendKeys(language);
        Select selectLanguage = new Select(languageInput);
        selectLanguage.selectByVisibleText("Bash");
    }

    public void fillExpiration(String expiration) {
        expirationInput.sendKeys(expiration);
        Select selectExpiration = new Select(expirationInput);
        selectExpiration.selectByVisibleText("15 minutes");
    }

    public void fillDescription (String description) {
        descriptionInput.sendKeys(description);
    }

    public void clickSave () {
        saveButton.click();
    }

}