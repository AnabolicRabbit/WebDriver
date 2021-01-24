package com.epam.learn.bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BringItOnSlexySavedPage {

    private WebDriver driver;

    public BringItOnSlexySavedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int countSearchResultsForDescription() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("paste")));
        List<WebElement> resultsNumberForDescription = driver.findElements(By.xpath("//tbody/tr[2]/td[1]/b[text()='how to gain dominance among developers']"));
        return resultsNumberForDescription.size();
    }

    public int countSearchResultsForBash() {
        List<WebElement> resultsNumberForBash = driver.findElements(By.xpath("//div/div[@class='bash']"));
        return resultsNumberForBash.size();
    }

    public int countSearchResultsForCode() {
        List<WebElement> resultsNumberForCode = driver.findElements(By.xpath("//span[contains(text(), 'New Sherif') and contains(text(), 'in Town')]"));
        return resultsNumberForCode.size();
    }

}