package com.epam.learn.bring_it_on.test;

import com.epam.learn.bring_it_on.page.BringItOnSlexyHomePage;
import com.epam.learn.bring_it_on.page.BringItOnSlexySavedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BringItOnSlexyTest {

    private WebDriver driver;
    public static BringItOnSlexyHomePage homePage;
    public static BringItOnSlexySavedPage savedPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homePage = new BringItOnSlexyHomePage(driver);
        savedPage = new BringItOnSlexySavedPage(driver);
        driver.manage().window().maximize();
    }

    @Test(description = "New Paste creation, verification of Page Title and Code")
    public void appropriatePageTitleCodeBash() {

        homePage.openPage();
        homePage.fillCode("git config --global user.name  'New Sheriff in Town'\n" +
                "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n" +
                "git push origin master --force");
        homePage.fillLanguage("");
        homePage.fillExpiration("");
        homePage.fillDescription("how to gain dominance among developers");
        homePage.clickSave();
        //savedPage.countSearchResultsForDescription();
        Assert.assertTrue(savedPage.countSearchResultsForDescription()>0, "Page Title does not match Description!");
        Assert.assertTrue(savedPage.countSearchResultsForBash()>0, "No Bash found!");
        Assert.assertTrue(savedPage.countSearchResultsForCode()>0, "Saved Code does not match the original!");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver=null;
    }

}