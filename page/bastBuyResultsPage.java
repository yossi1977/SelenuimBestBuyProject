package BestBuyProject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class bastBuyResultsPage {
    private ChromeDriver driver;

    // the price of the first element sony wh 1000 xm 5
    @FindBy(className = "priceView-customer-price")
    WebElement priceElement;

    //sort-by-select
    @FindBy(id = "sort-by-select")
    WebElement dropDown;

    @FindBy (className = "sku-title")
    WebElement name;

    public bastBuyResultsPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        String priceText = priceElement.getText();
        String[] priceParts = priceText.split("Your price for this item is ");
        return priceParts[0].trim();

    }

    public String getName(){
        return name.getText();
    }

    public void getDropDown(int selectOptionByIndex) {
        Select select = new Select(dropDown);
        select.selectByIndex(selectOptionByIndex);
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonAddToCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-sku-id='6505727'][data-button-state='ADD_TO_CART']")));
        buttonAddToCart.click();
    }
    public List<Double> getProductsPrices() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));; // 10-second wait

        // Wait for the price elements to be loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("priceView-hero-price")));
        sleep(5000);
        List<WebElement> prices = this.driver.findElements(By.className("priceView-hero-price"));
        List<Double> getPriceAsDouble = new ArrayList<>();

        for (WebElement price : prices) {
            // take the price [o] -> then remove the $ -> parse to double;
            String onlyPrice = price.getText();
            // split return array ->  -> split by "Your price for this item i"
            String[] splitArray = onlyPrice.split("Your price for this item i");
            String priceString = splitArray[0].replace("$", "");

            getPriceAsDouble.add(Double.parseDouble(priceString));

        }
        return  getPriceAsDouble ;
    }

    
}
