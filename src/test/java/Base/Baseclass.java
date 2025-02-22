package Base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.ScreenShotutil;
import Utils.Utils;
import Utils.ConfigurationReader;

public class Baseclass extends ConfigurationReader {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Utils.browserLaunch();  // Launch browser with URL
        driver = Utils.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot if the test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenShotutil.captureScreenshot(driver, result.getName());
        }
        Utils.closeBrowser();  // Close browser after test execution
    }
}

