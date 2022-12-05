package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;

    @FindBy(how = How.CSS, using = ".icon-remove")
    WebElement deleteButton;
    
    @FindBy(how = How.XPATH, using = "//a[@id='cart-icon-bubble']/div[1]/span[2]")
    WebElement cartCount;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void clearCart() { 
        deleteButton.click();
    }

    public int getCartCount() {
    	
    	String count = cartCount.getText();
    	int c = Integer.parseInt(count);
        return c;
    }
}
