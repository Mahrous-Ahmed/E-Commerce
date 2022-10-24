package Screens;

import Base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.Set;

public class GooglePage extends BaseScreen {

    @FindBy(name = "q")
    WebElement searchField;


    public GooglePage(AndroidDriver driver) throws InterruptedException {
        super(driver);
    }

    public void SearchUsingKeyWord(String keyWord){
        searchField.sendKeys(keyWord);
        searchField.sendKeys(Keys.ENTER);
        backToPreviousScreen();
        driver.context("NATIVE_APP");
    }



}
