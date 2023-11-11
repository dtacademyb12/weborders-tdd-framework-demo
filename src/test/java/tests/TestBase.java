package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

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



    @BeforeSuite (alwaysRun = true)
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

    @AfterSuite(alwaysRun = true)
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
    public void cleanUp(ITestResult testResult){

        if(testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("TEST PASSED. " + testResult.getName());
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            logger.fail("TEST FAILED. " + testResult.getName());
            logger.fail(testResult.getThrowable());
            // take screenshot
            String screenshotFilePath = SeleniumUtils.getScreenshot("failedTest");
            //attach it to the report
            logger.addScreenCaptureFromPath(screenshotFilePath);
        } else if (testResult.getStatus() == ITestResult.SKIP) {
            logger.skip("TEST SKIPPED. " + testResult.getName());
        }

        Driver.quitDriver();
    }
}
