package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Driver;

import java.time.Duration;

public class TestBase {


    // Using Inheritance in the form of TestBase class helps:
    // -readability
    // -maintainability
    // -reusability/scalability




    @BeforeMethod(alwaysRun = true)
    public void setupTest(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        Driver.quitDriver();
    }
}
