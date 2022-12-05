package com.sdet;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;


public class CartTests {

    @Test(description = "LEVEL-2")
    public void shouldClearCart() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(4);
        Thread.sleep(3000);
        homePage.viewCart();
        
        new CartPage(driver).clearCart();
        

        driver.quit();
    }


    @Test(description = "LEVEL-2")
    public void shouldAddItemCart() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(4);

        int cartCount = new CartPage(driver).getCartCount();
        Assert.assertEquals(cartCount, 1);

        driver.quit();

    }

   /* @Test(description = "LEVEL-3")
    public void shouldIncreaseTotalPriceOnIncreasingQuantity() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testvagrant.myshopify.com/");

        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(1);

        //ToDo: Remove below line & complete the test
        Assert.assertEquals(1, 0);

        driver.quit();

    }*/


}
