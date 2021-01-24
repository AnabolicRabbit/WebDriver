package com.epam.learn.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HurtMePlentyCloudGoogleSearchResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement pricingCalculator;

    public HurtMePlentyCloudGoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPricingCalculator () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='gs-webResult gs-result']")));
        pricingCalculator.click();
    }

}
