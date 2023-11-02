package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests extends TestBase {






    @Test (groups = "smoke")
    public void positiveLogin(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Orders");


    }


    @Test (groups = "smoke")
    public void negativeLoginWithInvalidUsername(){



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("InvalidUser", Keys.TAB, "test", Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");



    }

    @Test
    public void negativeLoginWithInvalidPassword(){



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "invalid", Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");



    }

    @Test (groups = "smoke")
    public void negativeLoginWithNoCredentials(){



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");



    }


}
