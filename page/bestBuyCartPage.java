package BestBuyProject.page;

import oop.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bestBuyCartPage {

    private ChromeDriver driver;

    @FindBy (className = "cart-item__title")
    WebElement name;

    @FindBy(className = "price-block__inline")
    WebElement price;

    public bestBuyCartPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String  getNameOfProduct(){
         return name.getText();
    }
    public String getPriceOfProduct(){
        return price.getText();
    }
}
