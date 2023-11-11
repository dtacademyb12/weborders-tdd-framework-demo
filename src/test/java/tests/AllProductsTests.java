package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.AllProductsPage;
import pages.LoginPage;
import utils.SeleniumUtils;

import java.util.List;

public class AllProductsTests extends TestBase {



    @Test (groups = "smoke")
    public  void verifyColumnNames(){

       new LoginPage().validLogin();

        new AllOrdersPage().getViewAllProductsLink().click();

        List<String> expected = List.of("Product name", "Price", "Discount");

        List<WebElement> columns = new AllProductsPage().getColumns();

        List<String> actual = SeleniumUtils.getElementsText(columns );

        Assert.assertEquals(actual, expected);


    }


    @Test (groups = "smoke")
    public  void verifyProductNames(){

        new LoginPage().validLogin();

        new AllOrdersPage().getViewAllProductsLink().click();

        List<String> expected = List.of("Mymoney", "FamilyAlbum", "ScreenSaver");

        List<WebElement> productNames = new AllProductsPage().getProductNames();

        List<String> actual = SeleniumUtils.getElementsText(productNames );

        Assert.assertEquals(actual, expected);


    }

    @Test
    public  void skippedTest(){

        // How to explicitly mark a test case SKIPPED?

        throw new SkipException("Test is not ready");
    }


}
