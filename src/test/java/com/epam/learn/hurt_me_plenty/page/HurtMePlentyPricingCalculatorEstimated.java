package com.epam.learn.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HurtMePlentyPricingCalculatorEstimated {

    private WebDriver driver;

    public HurtMePlentyPricingCalculatorEstimated(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int checkVMClass() {
        List<WebElement> vMClass = driver.findElements(By.xpath("//*[@id='compute']/md-list/md-list-item[2]/div[contains(text(), 'regular')]"));
        return vMClass.size();
    }

    public int checkInstanceType() {
        List<WebElement> instanceType = driver.findElements(By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div[contains(text(), 'n1-standard-8')]"));
        return instanceType.size();
    }

    public int checkRegion() {
        List<WebElement> region = driver.findElements(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div[contains(text(), 'Frankfurt')]"));
        return region.size();
    }

    public int checkLocalSSD() {
        List<WebElement> localSSD = driver.findElements(By.xpath("//*[@id='compute']/md-list[1]/md-list-item[8]/div[contains(text(), '2x375')]"));
        return localSSD.size();
    }

    public int checkCommitmentTerm() {
        List<WebElement> commitmentTerm = driver.findElements(By.xpath("//*[@id='compute']/md-list[1]/md-list-item[9]/div[contains(text(), '1 Year')]"));
        return commitmentTerm.size();
    }

    public int checkEstimatedComponentCost() {
        List<WebElement> estimatedComponentCost = driver.findElements(By.xpath("//*[@id='compute']/md-list[1]/md-list-item[10]/div/b[contains(text(), 'USD') and contains(text(), '1,841.97')]"));
        return estimatedComponentCost.size();
    }

    public int checkTotalEstimatedCost() {
        List<WebElement> totalEstimatedCost = driver.findElements(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b[contains(text(), 'USD') and contains(text(), '1,841.97')]"));
        return totalEstimatedCost.size();
    }

}
