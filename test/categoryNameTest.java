package BestBuyProject.test;


import BestBuyProject.page.bestBuyMainPage;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectSwagLab.tests.seleniumBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class categoryNameTest {
    public static void main(String[] args) {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.bestbuy.com/?intl=nosplash");
        bestBuyMainPage bestBuyMainPage = new bestBuyMainPage(driver);
        List<String> expectedCategories = new ArrayList<>(Arrays.asList(
                "Holiday Deals", "Gift Cards", "Gift Ideas", "Top Deals", "Deal of the Day"));

        List<String> categoriesNames = bestBuyMainPage.getCategoriesNames();

        Assert.assertEquals("Test failed: The categories name  are not as expected", expectedCategories, categoriesNames);
        System.out.println("Test passed: The categories names are as expected.");

        base.seleniumClose(driver);
        System.out.println("Test End ...");
    }
}
