package Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/General-Store.apk");
        caps.setCapability("autowebview", true);
        caps.setCapability("chromedriverExecutable", "/Users/admin/Downloads/E-Commerce/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver","/Users/admin/Downloads/E-Commerce/src/main/resources/chromedriver");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);




    }

    @AfterMethod
    public void TakeScreenshot(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {

            TakesScreenshot ts = (TakesScreenshot) (WebDriver) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./ScreenShots/" + result.getName() + ".png"));

        }
    }



    public void tearDown(){
        if(driver != null)
            driver.quit();
    }
}
