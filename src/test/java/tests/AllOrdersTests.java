package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests extends TestBase{


    @Test (groups = "smoke")
    public void verifyCheckAll(){

        new LoginPage().getUsernameField().sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        AllOrdersPage allOrdersPage = new AllOrdersPage();
        allOrdersPage.getCheckAllButton().click();
        List<WebElement> checkboxes = allOrdersPage.getCheckboxes();
        checkboxes.forEach(s -> Assert.assertTrue(s.isSelected()));


    }

}
