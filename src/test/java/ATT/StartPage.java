package ATT;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends PageObject {

    @FindBy(className ="home-logo__default")
    private WebElement marketButton;

    @FindBy(css=".home-link.home-link_blue_yes.home-tabs__link.home-tabs__search")
    private List<WebElement> mainMenuElements;

    @FindBy(className="home-tabs__more-switcher")
    private WebElement switcherMenu;

    @FindBy(className="home-tabs__more-link")
    private List<WebElement> moreItemMenu;

    public StartPage(WebDriver driver) {
        super(driver);
    }
    public boolean isInitialized() {
        return marketButton.isDisplayed();
    }

    public void selectMainMenuItem(String menuName){
        boolean itemExists = true;
        try {
            selectMenuItemToClick(this.mainMenuElements, menuName);
        }
        catch (NullPointerException e) {
            this.switcherMenu.click();
            itemExists = false;
        }

        if (!itemExists){
            try {
                selectMenuItemToClick(this.moreItemMenu, menuName);}
            catch (NullPointerException e2) {
                Assert.assertTrue("Такого элемента меню не существует", false);
            }
        }
    }
}
