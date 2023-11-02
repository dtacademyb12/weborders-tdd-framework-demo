package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests {


    WebDriver driver;


    @BeforeGroups (groups = "smoke")
    public void setup(){
        System.out.println("Smoke tests setup DONE");
    }

    @AfterGroups (groups = "smoke")
    public void tearDown(){
        System.out.println("Smoke tests teardown is DONE");
    }

    @BeforeMethod (alwaysRun = true)
   public void setupTest(){
       driver = new ChromeDriver();

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
   }

   @AfterMethod (alwaysRun = true)
   public void cleanUp(){
       driver.quit();
   }

//   @Before
//    public void another(){
//       System.out.println("Junit test");
////       org.junit.Assert.assertEquals(, );
//    }


    @Test (groups = "smoke")
    public void positiveLogin(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web OrdersVGHXS");


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
