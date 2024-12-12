package BestBuyProject.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bestBuySideCartPage {

    private ChromeDriver driver;

    @FindBy (className = "go-to-cart")
    WebElement sideCart;

    public bestBuySideCartPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickGoToCart(){
        sideCart.click();
    }

}
