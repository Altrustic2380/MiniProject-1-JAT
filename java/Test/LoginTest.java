package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Baseclass;
import Page.Login;
import Utils.ConfigurationReader;

public class LoginTest extends Baseclass {
    private Login loginPage;
    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new Login(driver);  // Initialize LoginPage

        // Fetch credentials from config.properties
        username = ConfigurationReader.getProperty("username");
        password = ConfigurationReader.getProperty("password");
    }

    @Test
    public void testValidLogin() {
        loginPage.login(username, password);

        // Verify user is logged in by checking welcome message
        Assert.assertTrue(loginPage.isUserLoggedIn(), "Login failed!");
        Assert.assertTrue(loginPage.getUserWelcomeMessage().contains("Welcome"), "Welcome message not displayed!");

        System.out.println("Login Successful! Welcome message: " + loginPage.getUserWelcomeMessage());
    }
}


