package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class LoginTests extends TestBase {






    @Test (groups = "smoke")
    public void positiveLogin(){

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals( Driver.getDriver().getTitle(), "Web Orders");


    }


    @Test (groups = "smoke")
    public void negativeLoginWithInvalidUsername(){



        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("InvalidUser", Keys.TAB, "test", Keys.ENTER);

        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");



    }

    @Test
    public void negativeLoginWithInvalidPassword(){



        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "invalid", Keys.ENTER);

        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");



    }

    @Test (groups = "smoke")
    public void negativeLoginWithNoCredentials(){



        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);

        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");



    }


}
