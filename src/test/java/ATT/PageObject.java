package ATT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItemToClick(List<WebElement> element, String menuName) {

        WebElement menuItem = null;
        for(WebElement e : element) {
            if (e.getText().equals(menuName)) {
                menuItem=e;
                break;
            }
        }
        menuItem.click();
    }
}
