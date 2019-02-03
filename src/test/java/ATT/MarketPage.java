package ATT;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MarketPage extends PageObject{

        @FindBy(className="n-w-tab__control-caption")
        private List<WebElement> controlTab; //MainMenu MarketPage

        @FindBy(css="._2qvOOvezty._2x2zBaVN-3._9qbcyI_fyS")
        private List<WebElement> subControlTab; //SubMenu MarketPage

        @FindBy(className="_28j8Lq95ZZ")
        private WebElement filterButton;

        @FindBy(className="n-snippet-cell2_type_product")
        public List<WebElement> serchResult;

        @FindBy(className="button2")
        private WebElement serchButton;

        @FindBy(xpath="/html/body/div[1]/div[5]/div[2]/div[2]/div/div[1]/div[1]")
        public WebElement serchProduct;

        @FindBy(id="header-search")
        private WebElement serchInput;

        @FindBy(className="n-snippet-cell2__main-price-wrapper")
        private List<WebElement> elementsSort;

        @FindBy(xpath="/html/body/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[3]/a")
        private WebElement buttonSort;

        @FindBy(className="preloadable_plreloader")
        private WebElement loadPanel;

    public MarketPage(WebDriver driver) {
            super(driver);
        }

    public void turnOnSort(){
        this.buttonSort.click();
    }

    public void selectMarketMenuItem(String menuName) {
        try {
            selectMenuItemToClick(this.controlTab, menuName);
        } catch (NullPointerException e) {
            Assert.assertTrue("Такого элемента меню не существует", false);
        }
    }

    public void selectMarketSubMenuItem(String menuName){
        try {
            selectMenuItemToClick(this.subControlTab, menuName);
        } catch (NullPointerException e) {
            Assert.assertTrue("Такого элемента меню не существует", false);
        }
    }

    public void openFilterPage(){
        this.filterButton.click();
    }

    public void enterSercheResult(String serchText){
        this.serchInput.sendKeys(serchText);
        this.serchButton.click();
    }

    public String saveValue(int numberValue){
        String firstElement = this.serchResult.get(numberValue).getText();
        String firstElementText = firstElement.substring(0, firstElement.indexOf("\n"));
        return firstElementText;
    }

    public boolean checkSorting() {

        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloadable_plreloader")));

        int value = 0;
        int nextValue = 0;
        boolean flagSort = true;
        String price;

        for (WebElement e : elementsSort) {

            price = e.getText().replaceAll("\\s","");
            nextValue = Integer.parseInt(price.substring(0, price.indexOf("\u20BD")));

            if (value > nextValue)
            {
                flagSort = false;
                break;
            }

            value = nextValue;
        }
        return flagSort;
    }
}
