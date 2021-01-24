package com.epam.learn.i_can_win.test;

import com.epam.learn.i_can_win.page.ICanWinSlexyHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinSlexyTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Population of Code, Expiration, Description on Slexy.org")
    public void fieldsAreFilled() {

        ICanWinSlexyHomePage fillingOfField = new ICanWinSlexyHomePage(driver)
                .openPage()
                .fillCode("Hello from WebDriver")
                .fillExpiration("")
                .fillDescription("helloweb");

    }

    @AfterMethod(alwaysRun = true)
    public void browserClosure() {

        driver.quit();
        driver=null;
    }

}