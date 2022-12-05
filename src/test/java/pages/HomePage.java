package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//p[contains(.,'Shopping should be fun, convenient and affordable')]")
    private WebElement ourMissionText;
    
    @FindBy(how = How.XPATH, using = "//a[@id='cart-icon-bubble']")
    public WebElement cartIcon;
    
    @FindBy(how = How.CSS, using = ".icon-search")
    public WebElement searchButton;

    @FindBy(how = How.CSS, using = ".icon-cart")
    public WebElement cartButton;

    @FindBy(how = How.ID, using = "Search-In-Modal")
    public WebElement searchTextBox;

    
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   
     public String getOurMissionText() {
        return ourMissionText.getText();
    }

    public void search(String text) {
        searchButton.click();
        searchTextBox.sendKeys(text);
    }
    
    public boolean searchContents() {
        List<WebElement> contents = driver.findElements(By.xpath("//ul[@id='predictive-search-results-list']"));
   
    for(WebElement value: contents)
    {
   
    	boolean text = value.getText().contains("adidas");
    	return true;
    }
    
	return false;
    
    }
    

    public void addProductsToCart(int productsCount) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-grid .grid__item"));

        for (int i = 3; i < productsCount; i++) {
        
            elements.get(i).click(); 
           
            new ProductPage(driver).addToCart();
        }
    }
           
            
        
    public void viewCart() {
    	
       cartIcon.click();
       
    }
}
 