package ATT;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterPage extends PageObject{

    @FindBy(id="glf-pricefrom-var")
    private WebElement minPrice;

    @FindBy(className="button_size_l")
    private WebElement enterFiltre;

    @FindBy (className = "checkbox__label")
    private List<WebElement> manufacturer; //SubMenu MarketPage

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public void enterMinPrice(String minPrice){
        this.minPrice.sendKeys(minPrice);
    }

    public void selectManuFacturer(String manuFacturerName){
        try{
            selectMenuItemToClick(this.manufacturer, manuFacturerName);
        } catch (NullPointerException e) {
            Assert.assertTrue("Такого производителя не существует", false);
        }
    }

    public void applyFilter(){
        this.enterFiltre.click();
    }
}
