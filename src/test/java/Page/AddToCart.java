package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AddToCart {
    private WebDriver driver;

    @FindBy(id = "cartur")  // Locator to open the cart page
    private WebElement cartLink;

    @FindBy(xpath = "//tbody/tr") // Locator for cart items
    private List<WebElement> cartItems;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]") // Example locator for a button in the cart
    private WebElement placeOrderButton;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to the cart page
    public void goToCart() {
        cartLink.click();
    }

    // Check if the cart is empty or has products
    public boolean isCartNotEmpty() {
        return !cartItems.isEmpty(); // Returns true if at least one item is present
    }

    // Get the count of items in the cart
    public int getCartItemCount() {
        return cartItems.size();
    }

    // Check if "Place Order" button is displayed (indicating cart is not empty)
    public boolean isPlaceOrderVisible() {
        return placeOrderButton.isDisplayed();
    }

	public WebElement getCartTable() {
		// TODO Auto-generated method stub
		return null;
	}
}

