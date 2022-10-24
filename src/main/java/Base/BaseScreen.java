package Base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseScreen {

    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void waitForElement(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver , 15);
        wait.until(ExpectedConditions.visibilityOf(element));

    }



    protected void enterDataToField(MobileElement element , String text){
        clear(element);
        element.sendKeys(text);
    }


    protected void clear(MobileElement element ){
        waitForElement(element);
        element.clear();
    }

    protected String  getText(MobileElement element ){
        waitForElement(element);
        return element.getText();
    }


    protected String  getAttribute(MobileElement element ,String attribute ){
        waitForElement(element);
        return element.getAttribute(attribute);
    }


    protected void  clickOnButton(MobileElement element){
        waitForElement(element);
        element.click();
    }

    protected void hitEnter() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }


    protected void hideKeyboard() {
       driver.hideKeyboard();
    }

    protected void longPressOnButton(MobileElement element) {
        AndroidTouchAction touchAction = new AndroidTouchAction(driver);
        touchAction.longPress(ElementOption.element(element)).perform();
    }


    protected void scrollToSpecificText(String Text) {
     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +Text +"\"));");
    }

    protected void landscape(){
        driver.rotate(new DeviceRotation(0, 0, 90));
    }

    protected void backToPreviousScreen(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


    protected void navigateToHomeScreen(){
         driver.pressKey(new KeyEvent(AndroidKey.HEADSETHOOK));
    }

    protected void swipingLeft(MobileElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId" , ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));

    }










}
