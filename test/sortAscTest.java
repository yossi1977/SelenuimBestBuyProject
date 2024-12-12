package BestBuyProject.test;

import BestBuyProject.page.bastBuyResultsPage;
import BestBuyProject.page.bestBuyMainPage;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectSwagLab.tests.seleniumBase;
import java.util.List;

public class sortAscTest {
    public static void main(String[] args) throws InterruptedException {
        pageObjectSwagLab.tests.seleniumBase base = new seleniumBase();
        ChromeDriver driver =  base.seleniumInit("https://www.bestbuy.com/?intl=nosplash");
        bestBuyMainPage bestBuyMainPage = new bestBuyMainPage(driver);
        bastBuyResultsPage bastBuyResultsPage = new bastBuyResultsPage(driver);

        bestBuyMainPage.setSearchText("sony wh 1000 xm 5");
        bastBuyResultsPage.getDropDown(3);

        List<Double> pricesLowToHigh =bastBuyResultsPage.getProductsPrices();
        for (int i=0 ; i<pricesLowToHigh.size() -1 ;i++){
            Assert.assertTrue("Test fail: Prices are not sorted in ascending order", pricesLowToHigh.get(i) <=pricesLowToHigh.get(i + 1));
        }

        System.out.println("Prices are sorted correctly from low to high.");
        base.seleniumClose(driver);
        System.out.println("Test End ...");
    }

}
