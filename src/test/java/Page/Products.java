package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.time.Duration;

public class Products {
    private WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(id = "next2")
    private WebElement nextButton;

    @FindBy(id = "prev2")
    private WebElement previousButton;

    @FindBy(className = "card-title")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Scroll Down
    public void scrollDown() {
        js.executeScript("window.scrollBy(0,1000)");
    }

    // Scroll Up
    public void scrollUp() {
        js.executeScript("window.scrollBy(0,-1000)");
    }

    // Click Next Page button
    public void goToNextPage() {
        if (nextButton.isDisplayed()) {
            nextButton.click();
        }
    }

    // Click Previous Page button
    public void goToPreviousPage() {
        if (previousButton.isDisplayed()) {
            previousButton.click();
        }
    }

    // Select the first available product
    public void clickOnFirstProduct() {
        if (!productList.isEmpty()) {
            productList.get(0).click();
        }
    }

    // Add the product to the cart
    public void addToCart() {
        addToCartButton.click();
    }

    // Go to the cart page
    public void goToCart() {
        cartLink.click();
    }

    // Get cart item count
    public int getCartItemCount() {
        List<WebElement> cartItems = driver.findElements(By.xpath("//tbody/tr"));
        return cartItems.size();
    }

	public By getAddToCartButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
