package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;

import java.util.List;

public class AllOrdersTests extends TestBase {


    @Test (groups = "smoke")
    public void verifyCheckAll(){

        new LoginPage().getUsernameField().sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        AllOrdersPage allOrdersPage = new AllOrdersPage();
        allOrdersPage.getCheckAllButton().click();
        List<WebElement> checkboxes = allOrdersPage.getCheckboxes();
        checkboxes.forEach(s -> Assert.assertTrue(s.isSelected()));


    }

}
