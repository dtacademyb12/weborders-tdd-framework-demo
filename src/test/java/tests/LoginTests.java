package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Driver;

public class LoginTests extends TestBase {






    @Test (groups = "smoke")
    public void positiveLogin(){

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals( Driver.getDriver().getTitle(), "Web Orders");

    }

    @Test (groups = "smoke")
    public void negativeLoginWithInvalidUsername(){

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().sendKeys("InvalidUser", Keys.TAB, "test", Keys.ENTER);


        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");

    }
    @Test
    public void negativeLoginWithInvalidPassword(){
        logger.info("Logging in...");
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().sendKeys("Tester", Keys.TAB, "invalid", Keys.ENTER);

        logger.info("Assertion of the title...");

        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");

    }
    @Test (groups = "smoke")
    public void negativeLoginWithNoCredentials(){

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().sendKeys("", Keys.TAB, "", Keys.ENTER);

        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");

    }


}
