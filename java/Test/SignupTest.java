package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Baseclass;
import Page.Signup;
import Utils.ConfigurationReader;

public class SignupTest extends Baseclass {
    private Signup signupPage;
    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        signupPage = new Signup(driver);

        // Fetching credentials from config.properties
        username = ConfigurationReader.getProperty("username");
        password = ConfigurationReader.getProperty("password");
    }

    @Test
    public void testValidSignup() {
        signupPage.completeSignup(username, password);

        // Verify that sign-up was successful (Example: Check for an alert popup)
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Sign up successful"), "Sign up failed!");

        // Accept the alert
        driver.switchTo().alert().accept();
    }
}

