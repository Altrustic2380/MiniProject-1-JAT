package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Baseclass;
import Page.Products;
import Page.Login;
import Utils.ConfigurationReader;
import Utils.ScreenShotutil;

import java.time.Duration;

public class ProductsTest extends Baseclass {
    private Products productsPage;
    private Login loginPage;

    @BeforeMethod
    public void setUpTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Apply implicit wait
        productsPage = new Products(driver);
        loginPage = new Login(driver);

        // Perform login
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
        ScreenShotutil.captureScreenshot(driver, "Login_Success");

        System.out.println("Login successful. Proceeding with product purchase flow.");
    }

    @Test
    public void testProductPurchaseFlow() {
        performPageNavigation();
        selectAndAddProductToCart();
        verifyProductInCart();
    }

    private void performPageNavigation() {
        try {
            Thread.sleep(2000); // Slower scroll for better visibility
            productsPage.scrollDown();
            ScreenShotutil.captureScreenshot(driver, "Scrolled_Down");

            Thread.sleep(2000);
            productsPage.goToNextPage();
            ScreenShotutil.captureScreenshot(driver, "Clicked_Next");

            Thread.sleep(2000);
            productsPage.scrollUp();
            ScreenShotutil.captureScreenshot(driver, "Scrolled_Up");

            Thread.sleep(2000);
            productsPage.goToNextPage();
            ScreenShotutil.captureScreenshot(driver, "Clicked_Next_Again");

            System.out.println("Page navigation completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void selectAndAddProductToCart() {
        try {
            Thread.sleep(2000);
            productsPage.clickOnFirstProduct();
            ScreenShotutil.captureScreenshot(driver, "Product_Selected");

            Thread.sleep(2000);
            productsPage.addToCart();
            ScreenShotutil.captureScreenshot(driver, "Product_Added_To_Cart");

            System.out.println("Product selected and added to cart.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verifyProductInCart() {
        try {
            Thread.sleep(2000);
            productsPage.goToCart();
            ScreenShotutil.captureScreenshot(driver, "Cart_Page");

            Thread.sleep(2000);
            Assert.assertTrue(productsPage.getCartItemCount() > 0, "Cart is empty!");

            System.out.println("Product successfully verified in cart.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

