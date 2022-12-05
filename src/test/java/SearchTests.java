import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchTests {

    @Test(description = "LEVEL-1")
    public void shouldVerifySearchResults()  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        homePage.search("adidas");
       

        //ToDo: Remove below line & Please add assertion logic. Assert that every search result contains search text.
        Assert.assertEquals(true, homePage.searchContents());
        driver.quit();
    }

}
