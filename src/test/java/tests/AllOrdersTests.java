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
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests extends TestBase{


    @Test (groups = "smoke")
    public void verifyCheckAll(){
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes =
                Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        checkboxes.forEach(s -> Assert.assertTrue(s.isSelected()));


    }

}
