package BestBuyProject.test;

import BestBuyProject.page.bastBuyResultsPage;
import BestBuyProject.page.bestBuyCartPage;
import BestBuyProject.page.bestBuyMainPage;
import BestBuyProject.page.bestBuySideCartPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectSwagLab.tests.seleniumBase;

import java.time.Duration;
import static java.lang.Thread.sleep;

public class addToCartTest {
    public static void main(String[] args) throws InterruptedException {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.bestbuy.com/?intl=nosplash");
        bestBuyMainPage bestBuyMainPage = new bestBuyMainPage(driver);
        bastBuyResultsPage bastBuyResultsPage = new bastBuyResultsPage(driver);
        bestBuySideCartPage bestBuySideCart = new bestBuySideCartPage(driver);
        bestBuyCartPage bestBuyCartPage = new bestBuyCartPage(driver);
        bestBuyMainPage.setSearchText("sony wh 1000 xm 5");

        //  Get the price and name of product  to compare with the price in the cart
        String priceFromResults = bastBuyResultsPage.getPrice();
        String nameFromResults = bastBuyResultsPage.getName();

        // wait for loading the buttons elements page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-button-state='ADD_TO_CART']")));

        //scroll down for 300 pixel to avoid banner that cover the button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");

        bastBuyResultsPage.clickAddToCart();
        bestBuySideCart.clickGoToCart();

        // get the name and price of product from cart
        String nameFromCart = bestBuyCartPage.getNameOfProduct();
        String priceFromCart = bestBuyCartPage.getPriceOfProduct();

        // check if the price and name  in cart ==  name  and price from resolutes
        Assert.assertEquals("Test Fail : The price from Results not mach to price from Cart",
                priceFromResults, priceFromCart);
        System.out.println("Test pass: The price from Results  mach to price from Cart: ");
        System.out.println("Price From Results: " + priceFromResults);
        System.out.println("Price From Cart: " + priceFromCart);

        Assert.assertEquals("Test Fail: The name of product from Results not mach to name of product from Cart",
                nameFromResults, nameFromCart);
        System.out.println("Test pass: The name of product from Results not mach to name of product from Cart: ");
        System.out.println("Name From Results: " + nameFromResults);
        System.out.println("Name From Results: " + nameFromResults);

        sleep(5000);
        base.seleniumClose(driver);
        System.out.println("Test End ...");
    }
}
