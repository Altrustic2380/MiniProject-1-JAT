package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
    private WebDriver driver;

    // 1️⃣ Select a Product
    @FindBy(xpath = "//*[@id='tbodyid']/div[2]/div/a")  
    private WebElement secondProduct;

    // 2️⃣ Add to Cart
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")  
    private WebElement addToCartButton;

    // 3️⃣ Navigate to Cart Page
    @FindBy(id = "cartur")  
    private WebElement cartLink;

    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[4]/a") 
    private WebElement cartPageLink;

    // 4️⃣ Click "Place Order"
    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button") 
    private WebElement placeOrderButton;

    // 5️⃣ Fill Checkout Details
    @FindBy(id = "name")  
    private WebElement nameField;

    @FindBy(id = "country")  
    private WebElement countryField;

    @FindBy(id = "city")  
    private WebElement cityField;

    @FindBy(id = "card")  
    private WebElement cardField;

    @FindBy(id = "month")  
    private WebElement monthField;

    @FindBy(id = "year")  
    private WebElement yearField;

    // 6️⃣ Click "Purchase"
    @FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[2]") 
    private WebElement purchaseButton;

    // ✅ Order Confirmation
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]") 
    private WebElement confirmationMessage;

    public CheckOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Step 1: Select a Product
    public void selectProduct() {
        secondProduct.click();
    }

    // Step 2: Click "Add to Cart"
    public void addToCart() {
        addToCartButton.click();
    }

    // Step 3: Navigate to the Cart Page
    public void goToCart() {
        cartLink.click();
    }

    // Step 4: Click "Place Order"
    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    // Step 5: Fill Checkout Details
    public void enterCheckoutDetails(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    // Step 6: Click "Purchase"
    public void clickPurchase() {
        purchaseButton.click();
    }

    // ✅ Verify Order Confirmation
    public boolean isOrderConfirmed() {
        return confirmationMessage.isDisplayed();
    }
}

