package com.epam.learn.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HurtMePlentyCloudGoogleHomePage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchInput;

    public HurtMePlentyCloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='devsite-searchbox']")));
    }

    public void clickSearchButton () { searchButton.click(); }

    public void populateSearch (String searchQuery) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='devsite-search-field devsite-search-query']")));
        searchInput.sendKeys(searchQuery);
    }

}
