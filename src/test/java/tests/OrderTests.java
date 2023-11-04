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
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.OrderPage;
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


        new LoginPage().validLogin();
        new AllOrdersPage().getOrderLink().click();
        new OrderPage().placeOrder(fullname,street,city,state,zip,card);
        Assert.assertTrue( new OrderPage().getConfirmMessage().isDisplayed());








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
