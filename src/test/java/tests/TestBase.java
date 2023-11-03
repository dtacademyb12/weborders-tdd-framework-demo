package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
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
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        Driver.quitDriver();
    }
}
