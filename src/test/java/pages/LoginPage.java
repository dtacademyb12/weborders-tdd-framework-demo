package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {

  // Typically Page Object Model is used along with Page Factory that uses @FindBy annotations

  public LoginPage(){
    PageFactory.initElements(Driver.getDriver(), this);
  }

   // Basic Page Object Model demo
//  public WebElement getUsernameField() {
//    return usernameField;
//  }
//
//  private WebElement usernameField = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));


  @FindBy(id = "ctl00_MainContent_username")
  private WebElement usernameField;

  public WebElement getUsernameField() {
    return usernameField;
  }

  // Page classes can also store complex behaviors as methods
  public void validLogin(){
    usernameField.sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
  }
}
