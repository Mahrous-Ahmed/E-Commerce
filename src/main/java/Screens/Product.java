package Screens;

import Base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Locale;

public class Product extends BaseScreen {
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<MobileElement> productName;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<MobileElement> productPrice;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<MobileElement> productAddToCart;


    @AndroidFindBy(id = "appbar_btn_cart")
    private MobileElement btn_cart;



    private String [] ProductsInTheCart;
    private double price = 0;




    public Product(AndroidDriver driver) {
        super(driver);
    }

    public Cart navigateToCartScreen(){
        clickOnButton(btn_cart);
        return new Cart(driver,ProductsInTheCart);
    }




    public void addProductsIntoCart(String [] selectedProducts) throws InterruptedException {
        ProductsInTheCart = selectedProducts;

        for (String product: selectedProducts) {
             addToCart(product);
        }


    }

    private void addToCart(String product) throws InterruptedException {
        scrollToSpecificText(product);
        Thread.sleep(5000);
        int len = productName.size() - 1;


        for(int i = 0 ; i < len ; i++) {
            if(getText(productName.get(i)).equalsIgnoreCase((product)))
            {
                clickOnButton(productAddToCart.get(i));
            }

        }
    }


}
