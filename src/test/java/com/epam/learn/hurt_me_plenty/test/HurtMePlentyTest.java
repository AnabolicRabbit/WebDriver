package com.epam.learn.hurt_me_plenty.test;

import com.epam.learn.hurt_me_plenty.page.HurtMePlentyCloudGoogleHomePage;
import com.epam.learn.hurt_me_plenty.page.HurtMePlentyCloudGoogleSearchResultsPage;
import com.epam.learn.hurt_me_plenty.page.HurtMePlentyPricingCalculatorEstimated;
import com.epam.learn.hurt_me_plenty.page.HurtMePlentyPricingCalculatorHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

    private WebDriver driver;
    public static HurtMePlentyCloudGoogleHomePage cloudGoogleHomePage;
    public static HurtMePlentyCloudGoogleSearchResultsPage searchResultsPage;
    public static HurtMePlentyPricingCalculatorHomePage pricingCalculatorHomePage;
    public static HurtMePlentyPricingCalculatorEstimated pricingCalculatorEstimated;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        cloudGoogleHomePage = new HurtMePlentyCloudGoogleHomePage(driver);
        searchResultsPage = new HurtMePlentyCloudGoogleSearchResultsPage(driver);
        pricingCalculatorHomePage = new HurtMePlentyPricingCalculatorHomePage(driver);
        pricingCalculatorEstimated = new HurtMePlentyPricingCalculatorEstimated(driver);
        driver.manage().window().maximize();
    }

    @Test(description = "Verification of VM Class, Instance type, Region, local SSD, commitment term and rental amount")
    public void appropriateCalculationOfRentalAmount() throws InterruptedException {

        cloudGoogleHomePage.openPage();
        cloudGoogleHomePage.clickSearchButton();
        cloudGoogleHomePage.populateSearch("Google Cloud Platform Pricing Calculator\n");
        searchResultsPage.selectPricingCalculator();
        pricingCalculatorHomePage.populateNumberOfInstances("4");
        pricingCalculatorHomePage.populateTheseInstancesFor("");
        pricingCalculatorHomePage.populateOperatingSystemSoftware();
        pricingCalculatorHomePage.populateMachineClass();
        pricingCalculatorHomePage.populateSeries("N1");
        pricingCalculatorHomePage.populateMachineType();
        pricingCalculatorHomePage.checkAddGPUs();
        pricingCalculatorHomePage.populateDatacenterLocation();
        pricingCalculatorHomePage.populateNumberOfGPUs("1");
        pricingCalculatorHomePage.populateGPUType();
        pricingCalculatorHomePage.populateLocalSSD();
        pricingCalculatorHomePage.populateCommittedUsage();
        pricingCalculatorHomePage.clickAddToEstimate();
        Assert.assertTrue(pricingCalculatorEstimated.checkVMClass()>0, "Estimated VM Class does not match the original!");
        Assert.assertTrue(pricingCalculatorEstimated.checkInstanceType()>0, "Estimated Instance Type does not match the original!");
        Assert.assertTrue(pricingCalculatorEstimated.checkRegion()>0, "Estimated Region does not match the original!");
        Assert.assertTrue(pricingCalculatorEstimated.checkLocalSSD()>0, "Estimated Local SSD does not match the original!");
        Assert.assertTrue(pricingCalculatorEstimated.checkCommitmentTerm()>0, "Estimated Commitment Term does not match the original!");
        Assert.assertTrue(pricingCalculatorEstimated.checkEstimatedComponentCost()>0, "Estimated Component Cost does not match the calculated manually!");
        Assert.assertTrue(pricingCalculatorEstimated.checkTotalEstimatedCost()>0, "Total Estimated Cost does not match the calculated manually!");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver=null;
    }

}
