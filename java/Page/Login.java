package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;  // Explicit wait for better stability

    // Locators using @FindBy annotation with explicit XPaths
    @FindBy(xpath = "//*[@id='login2']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='loginusername']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='loginpassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='logInModal']/div/div/div[3]/button[2]")  // Login modal submit button
    private WebElement submitLoginButton;

    @FindBy(xpath = "//*[@id='nameofuser']")  // Welcome message (e.g., "Welcome AliceMax")
    private WebElement welcomeMessage;

    // Constructor to initialize elements
    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 sec explicit wait
        PageFactory.initElements(driver, this);
    }

    // Method to perform login
    public void login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(submitLoginButton)).click();
    }

    // Method to verify if user is logged in
    public boolean isUserLoggedIn() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to retrieve welcome text
    public String getUserWelcomeMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).getText();
        } catch (Exception e) {
            return "User not logged in";
        }
    }

	public boolean isLoginSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}
}


