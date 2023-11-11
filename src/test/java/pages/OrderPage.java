package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


@Data
public class OrderPage {


    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement fullName;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement state;


    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zip;


    @FindBy (name = "ctl00$MainContent$fmwOrder$cardList")
    private WebElement visaRadioButton;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNo;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expiry;

    @FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    @FindBy (tagName = "strong")
    private WebElement confirmMessage;





    public void placeOrder(String fullname,
                           String street,
                           String city,
                           String state,
                           String zip,
                           String card){
        quantity.sendKeys(Keys.BACK_SPACE, "2");
        fullName.sendKeys(fullname);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);

        visaRadioButton.click();

        cardNo.sendKeys(card);
        expiry.sendKeys("08/29");


        processButton.click();
    }


}
