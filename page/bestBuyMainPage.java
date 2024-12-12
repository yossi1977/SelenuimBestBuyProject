package BestBuyProject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class bestBuyMainPage {
    private ChromeDriver driver;

    @FindBy(id = "gh-search-input")
    WebElement search;

    public bestBuyMainPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearchText(String productName) {
        search.sendKeys(productName);
        search.sendKeys(Keys.RETURN);
    }

    public List<String> getCategoriesNames(){
        List <WebElement> categories =  this.driver.findElements(By.className("bottom-left-links"));
        List <String> categoriesNames = new ArrayList<>();
        for (WebElement category : categories){
            String text = category.getText();
            // to avoid empty element
            if (text != null && !text.isEmpty()){
                categoriesNames.add(category.getText().trim());
            }
        }
        return categoriesNames ;
    }
}
