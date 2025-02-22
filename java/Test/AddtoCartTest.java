package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Baseclass;
import Page.Products;
import Page.AddToCart;
import Utils.ScreenShotutil;
import java.time.Duration;

public class AddtoCartTest extends Baseclass {
    private Products productsPage;
    private AddToCart cartPage;

    @BeforeMethod
    public void setUpTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Apply implicit wait
        productsPage = new Products(driver);
        cartPage = new AddToCart(driver);
    }

    @Test
    public void testAddToCartFunctionality() {
        try {
            // Scroll down slowly
            Thread.sleep(2000);
            productsPage.scrollDown();
            ScreenShotutil.captureScreenshot(driver, "Scrolled_Down");

            // Select a product
            Thread.sleep(2000);
            productsPage.clickOnFirstProduct();
            ScreenShotutil.captureScreenshot(driver, "Product_Selected");

            // Add product to cart
            Thread.sleep(2000);
            productsPage.addToCart();
            ScreenShotutil.captureScreenshot(driver, "Product_Added_To_Cart");

            // Navigate to cart
            Thread.sleep(2000);
            cartPage.goToCart();
            ScreenShotutil.captureScreenshot(driver, "Cart_Page");

            // Verify product is in cart
            Assert.assertTrue(cartPage.isCartNotEmpty(), "Cart is empty after adding the product!");

            System.out.println("Product successfully added to cart and verified.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


