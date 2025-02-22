package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import Base.Baseclass;
import Page.Login;
import Page.CheckOut;
import Utils.ConfigurationReader;
import Utils.ScreenShotutil;

public class CheckOutTest extends Baseclass {
    private Login loginPage;
    private CheckOut checkOutPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait setup
        loginPage = new Login(driver);
        checkOutPage = new CheckOut(driver);

        // Perform login
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
        ScreenShotutil.captureScreenshot(driver, "Login_Success");

        System.out.println("Login successful. Proceeding with checkout flow.");
    }

    @Test
    public void testCheckoutProcess() {
        goToCartAndPlaceOrder();
        fillDetailsAndPurchase();
        verifyOrderConfirmation();
    }

    private void goToCartAndPlaceOrder() {
        try {
            Thread.sleep(2000);
            checkOutPage.goToCart();
            ScreenShotutil.captureScreenshot(driver, "Cart_Page");

            Thread.sleep(2000);
            checkOutPage.clickPlaceOrder();
            ScreenShotutil.captureScreenshot(driver, "Place_Order_Clicked");

            System.out.println("Navigated to cart and clicked 'Place Order'.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fillDetailsAndPurchase() {
        try {
            Thread.sleep(2000);
            checkOutPage.enterCheckoutDetails("John Doe", "USA", "New York", "1234567812345678", "12", "2025");
            ScreenShotutil.captureScreenshot(driver, "Checkout_Details_Filled");

            Thread.sleep(2000);
            checkOutPage.clickPurchase();
            ScreenShotutil.captureScreenshot(driver, "Purchase_Clicked");

            System.out.println("Checkout details filled and purchase completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verifyOrderConfirmation() {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(checkOutPage.isOrderConfirmed(), "Order confirmation message not displayed!");
            ScreenShotutil.captureScreenshot(driver, "Order_Confirmed");

            System.out.println("Order successfully placed and confirmed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


