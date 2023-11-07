package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Data
public class AllProductsPage {

    public AllProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//table[@class='ProductsTable']//th")
    List<WebElement> columns;


    @FindBy(xpath = "//table[@class='ProductsTable']//td[1]")
    List<WebElement> productNames;




}
