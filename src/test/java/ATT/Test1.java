package ATT;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

//1. Открыть браузер и развернуть на весь экран.
public class Test1 extends FunctionalTest{
    public static String url = "http://yandex.ru";

    @Test
    public void Test1()
        {
            driver.get(url);

            StartPage startPage = new StartPage(driver);
            assertTrue(startPage.isInitialized());

            startPage.selectMainMenuItem("Маркет");

            MarketPage marketPage = new MarketPage(driver);
            marketPage.selectMarketMenuItem("Электроника");

            marketPage.selectMarketSubMenuItem("Мобильные телефоны");

            marketPage.openFilterPage();

            FilterPage filterPage = new FilterPage(driver);

            filterPage.enterMinPrice("20000");

            filterPage.selectManuFacturer("Apple");
            filterPage.selectManuFacturer("Samsung");

            filterPage.applyFilter();

            Assert.assertTrue("Количество элементов на странице не равно 48", marketPage.serchResult.size()==48);

            String firstElementText = marketPage.saveValue(0);

            marketPage.enterSercheResult(firstElementText);

            Assert.assertEquals("Найденный товар("+marketPage.serchProduct.getText()+") не соответствет искомому: " + firstElementText, marketPage.serchProduct.getText(), firstElementText);
    }


    @Test
    public void Test2()
    {
        driver.get(url);

        StartPage startPage = new StartPage(driver);
        assertTrue(startPage.isInitialized());

        startPage.selectMainMenuItem("Маркет");

        MarketPage marketPage = new MarketPage(driver);
        marketPage.selectMarketMenuItem("Электроника");

        marketPage.selectMarketSubMenuItem("Наушники и Bluetooth-гарнитуры");

        marketPage.openFilterPage();

        FilterPage filterPage = new FilterPage(driver);

        filterPage.enterMinPrice("5000");

        filterPage.selectManuFacturer("Beats");

        filterPage.applyFilter();

        Assert.assertTrue("Количество элементов на странице не равно 48", marketPage.serchResult.size()==48);

        String firstElementText = marketPage.saveValue(0);

        marketPage.enterSercheResult(firstElementText);

        Assert.assertEquals("Найденный товар("+marketPage.serchProduct.getText()+") не соответствет искомому: " + firstElementText, marketPage.serchProduct.getText(), firstElementText);
    }

    @Test
    public void Test3() {
        driver.get(url);

        StartPage startPage = new StartPage(driver);
        assertTrue(startPage.isInitialized());

        startPage.selectMainMenuItem("Маркет");

        MarketPage marketPage = new MarketPage(driver);
        marketPage.selectMarketMenuItem("Электроника");

        marketPage.selectMarketSubMenuItem("Мобильные телефоны");

        marketPage.turnOnSort();

        Assert.assertTrue("Элементы отсортировоны неверно", marketPage.checkSorting());
        System.out.println("Элементы отсортировоны верно");
    }
}
