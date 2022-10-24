package Screens;

import Base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class GeneralStore extends BaseScreen {

    @AndroidFindBy(id = "toolbar_title")
    private MobileElement titleOfScreen;

    @AndroidFindBy(id = "spinnerCountry")
    private MobileElement spinnerCountry;

    @AndroidFindBy(id = "nameField")
    private MobileElement nameField;

    @AndroidFindBy(id = "radioMale")
    private MobileElement radioMale;

    @AndroidFindBy(id = "radioFemale")
    private MobileElement radioFemale;

    @AndroidFindBy(id = "btnLetsShop")
    private MobileElement btnLetsShop;

    @AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
    private MobileElement toastMessage;





    public GeneralStore(AndroidDriver driver) {
        super(driver);
    }

    public String getErrorMessage(){
        return toastMessage.getText();
    }

    public void clickOnShopButton(){
        clickOnButton(btnLetsShop);
    }

    public void selectMale(){
        clickOnButton(radioMale);
    }


    public void selectFemale(){
        clickOnButton(radioFemale);
    }

    public void addName(String name){
        enterDataToField(nameField ,  name);
    }

    public void selectCountry(String country){
        try {
            clickOnButton(spinnerCountry);
            scrollToSpecificText(country);
            driver.findElementByXPath("//android.widget.TextView[@text ='" +country +"']").click();
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public Product fillForm(String Country , String name , String gender){
        selectCountry(Country);
        addName(name);
        if (gender == "male") {
            selectMale();
        } else {
            selectFemale();
        }
        clickOnShopButton();
        return new Product(driver);
    }



}
