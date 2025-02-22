package Utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    private static WebDriver driver;

    // Fetch configurations from properties file
    private static final String BROWSER = ConfigurationReader.getProperty("browser");
    private static final String CHROME_DRIVER_PATH = ConfigurationReader.getProperty("chromedriver.path");
    private static final String BASE_URL = ConfigurationReader.getProperty("url");
    private static final int IMPLICIT_WAIT = Integer.parseInt(ConfigurationReader.getProperty("implicitWait"));

    public static void browserLaunch() {
        if (driver == null) {  // Prevent multiple instances
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            driver.manage().window().maximize();
            driver.get(BASE_URL);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset to prevent reuse after quit
        }
    }
}

