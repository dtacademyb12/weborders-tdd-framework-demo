package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class OrderTests extends TestBase{



    @Test (dataProvider = "feedData")
    public void placeOrder(String fullname,
                                          String street,
                                          String city,
                                          String state,
                                          String zip,
                                          String card
    ){


        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


        Driver.getDriver().findElement(By.linkText("Order")).click();

        Faker faker = new Faker();

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE, "2");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(fullname);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);

        Driver.getDriver().findElement(By.name("ctl00$MainContent$fmwOrder$cardList")).click();

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(card);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("08/29");


        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue( Driver.getDriver().findElement(By.tagName("strong")).isDisplayed());








    }



    @DataProvider
    public Object[][] feedData(){

        Faker faker = new Faker();
        return new Object[][] {
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},


        };
    }
}
