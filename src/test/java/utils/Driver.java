package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;


    private Driver(){}


    public static WebDriver getDriver(){

        if(driver == null){   // if it is not initialized, initialize it
            driver =  new ChromeDriver();
        }

        return driver;  // return the already initailized driver
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }

    }

}
