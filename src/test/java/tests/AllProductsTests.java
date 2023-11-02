package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.List;

public class AllProductsTests extends TestBase {



    @Test (groups = "smoke")
    public  void verifyColumnNames(){

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("View all products")).click();

        List<String> expected = List.of("Product name", "Price", "Discount");

        List<String> actual = SeleniumUtils.getElementsText( Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//th")));

        Assert.assertEquals(actual, expected);


    }


}
