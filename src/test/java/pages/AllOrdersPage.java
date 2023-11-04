package pages;

import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Data
//@Getter
public class AllOrdersPage {

    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private WebElement checkAllButton;

    @FindBy(xpath = "//input[@type='checkbox']")
//    @FindBy(css = "#dnsh")
//    @FindBy(className = "sdgd")
//    @FindBy(linkText = "Order")
//    @FindBy(tagName = "strong")
    private List<WebElement> checkboxes;


    @FindBy (linkText = "Order")
    private WebElement orderLink;






}
