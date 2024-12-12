package BestBuyProject.test;

import BestBuyProject.page.bastBuyResultsPage;
import BestBuyProject.page.bestBuyMainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectSwagLab.tests.seleniumBase;

import static java.lang.Thread.sleep;

public class searchProductPriceTest {
    public static void main(String[] args) throws InterruptedException {

        seleniumBase base = new seleniumBase();
        ChromeDriver driver =  base.seleniumInit("https://www.bestbuy.com/?intl=nosplash");

       bestBuyMainPage bestBuyMainPage = new bestBuyMainPage(driver);
        bestBuyMainPage.setSearchText("sony wh 1000 xm 5");

        // get the price of the fist product from the resolutes page
        bastBuyResultsPage bastBuyResultsPage = new bastBuyResultsPage(driver);
        String price = bastBuyResultsPage.getPrice();

        System.out.println( "The price of sony wh 1000 xm 5:");
        System.out.println("Best buy :" + price) ;

        sleep(3000);
        base.seleniumClose(driver);
        System.out.println("Test End ...");

    }
}
