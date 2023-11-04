package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.Driver;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {


    // Using Inheritance in the form of TestBase class helps:
    // -readability
    // -maintainability
    // -reusability/scalability

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentTest logger;



    @BeforeSuite
    public void setupReport(){
        extentReports = new ExtentReports();
        String path = System.getProperty("user.dir") + "/target/extentReports/report.html";
        htmlReporter = new ExtentSparkReporter(path);
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Project Name", "Weborders Automation Test Suite");
        extentReports.setSystemInfo("SDETs", "John Doe, Jane Smith");
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("URL", ConfigReader.getProperty("url"));
    }

    @AfterSuite
    public void tearDownReport(){
        extentReports.flush();
    }


    @BeforeMethod(alwaysRun = true)
    public void setupTest(Method method){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger = extentReports.createTest(method.getName());
        logger.info("TEST STARTED: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){

        logger.info("TEST FINISHED.");
        Driver.quitDriver();
    }
}
