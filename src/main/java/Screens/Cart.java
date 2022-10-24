package Screens;

import Base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Cart extends BaseScreen {

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<MobileElement> productPrice;


    @AndroidFindBy(id = "totalAmountLbl")
    private MobileElement totalAmount;

    @AndroidFindBy(id = "termsButton")
    private MobileElement termsButton;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement closeTerm;

    @AndroidFindBy(id = "btnProceed")
    private MobileElement btnProceed;


    @AndroidFindBy(className = "android.widget.CheckBox")
    private MobileElement checkBox;



    double totalPrice = 0;

    String[] products;


    public Cart(AndroidDriver driver , String[] products) {
        super(driver);
        this.products = products;
    }

    private double CalculatePrice(){

        for (MobileElement price: productPrice) {
             totalPrice += Double.valueOf(getText(price).substring(1));
            }

        return totalPrice;
    }


    public boolean priceAreEqual(){

        return CalculatePrice() == Double.valueOf(getText(totalAmount).substring(1));
    }
    public void openTerms(){
        longPressOnButton(termsButton);
        clickOnButton(closeTerm);
    }

    private void checked(){
        clickOnButton(checkBox);
    }
    private void purchased(){
        clickOnButton(btnProceed);
    }


    public GooglePage completePurchase(boolean isChecked) throws InterruptedException {
        if(isChecked)
            checked();
        purchased();

        Thread.sleep(2000);
        Set<String> strings = driver.getContextHandles();
        for (String s : strings) {
            System.out.println(s);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");

        return new GooglePage(driver);
    }







}
