package com.epam.learn.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HurtMePlentyPricingCalculatorHomePage {

    private WebDriver driver;

    @FindBy(id = "input_63")
    private WebElement numberOfInstances;

    @FindBy(id = "input_64")
    private  WebElement theseInstancesFor;

    @FindBy(id = "select_76")
    private WebElement operatingSystemSoftware;

    @FindBy(xpath = "//*[@id='select_option_65']/div[1]")
    private WebElement selectOperatingSystemSoftware;

    @FindBy(id = "select_80")
    private WebElement machineClass;

    @FindBy(xpath = "//*[@id='select_option_78']/div[1]")
    private WebElement selectMachineClass;

    @FindBy(id = "select_88")
    private  WebElement selectSeries;

    @FindBy(id = "select_90")
    private WebElement machineType;

    @FindBy(xpath = "//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div[1]")
    private WebElement selectMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private List<WebElement> addGPUs;

    @FindBy(id = "select_92")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//*[@id='select_option_205']/div[1]")
    private WebElement selectDatacenterLocation;

    @FindBy(id = "select_394")
    private WebElement numberOfGPUs;

    @FindBy(id = "select_396")
    private WebElement gPUType;

    @FindBy(xpath = "//*[@id='select_option_407']/div[1]")
    private WebElement selectGPUType;

    @FindBy(id = "select_355")
    private WebElement localSSD;

    @FindBy(xpath = "//*[@id='select_option_381']/div[1]")
    private WebElement selectLocalSSD;

    @FindBy(id = "select_99")
    private WebElement committedUsage;

    @FindBy(xpath = "//*[@id='select_option_97']/div[1]")
    private WebElement selectCommittedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private List<WebElement> addToEstimate;

    public HurtMePlentyPricingCalculatorHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void populateNumberOfInstances(String instances) {
        driver.switchTo().frame(0).switchTo().frame(0);
        numberOfInstances.sendKeys(instances);
    }

    public void populateTheseInstancesFor(String instancesFor) { theseInstancesFor.sendKeys(instancesFor); }

    public void populateOperatingSystemSoftware() {
        operatingSystemSoftware.click();
        selectOperatingSystemSoftware.click();
    }

    public void populateMachineClass() {
        machineClass.click();
        selectMachineClass.click();
    }

    public void populateSeries(String series) { selectSeries.sendKeys(series); }

    public void populateMachineType() {
        machineType.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div[1]")));
        selectMachineType.click();
    }

    public void checkAddGPUs() { addGPUs.get(0).click(); }

    public void populateDatacenterLocation() throws InterruptedException {
        datacenterLocation.click();
        Thread.sleep(100);
        selectDatacenterLocation.click();
    }

    public void populateNumberOfGPUs(String ofGPUs) { numberOfGPUs.sendKeys(ofGPUs); }

    public void populateGPUType() throws InterruptedException {
        gPUType.click();
        Thread.sleep(100);
        selectGPUType.click();
    }

    public void populateLocalSSD() throws InterruptedException {
        localSSD.click();
        Thread.sleep(100);
        selectLocalSSD.click();
    }

    public void populateCommittedUsage() {
        committedUsage.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_97']/div[1]")));
        selectCommittedUsage.click();
    }

    public void clickAddToEstimate() { addToEstimate.get(0).click(); }

}
