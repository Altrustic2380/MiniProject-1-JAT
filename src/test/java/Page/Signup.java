package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
    WebDriver driver;

    // Locators for Sign-Up elements
    @FindBy(xpath = "//*[@id='signin2']")
    private WebElement signupButton;

    @FindBy(xpath = "//*[@id='sign-username']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='sign-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']") // Sign-up confirmation button
    private WebElement confirmSignupButton;

    public Signup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click the Sign-up button to open the sign-up form
    public void clickSignup() {
        signupButton.click();
    }

    // Enter username and password
    public void enterSignupDetails(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    // Click the "Sign up" button to submit the form
    public void submitSignup() {
        confirmSignupButton.click();
    }

    // Complete signup process
    public void completeSignup(String username, String password) {
        clickSignup();
        enterSignupDetails(username, password);
        submitSignup();
    }
}
