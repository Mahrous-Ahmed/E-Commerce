package Tests;

import Base.BaseTest;
import Screens.Cart;
import Screens.GeneralStore;
import Screens.GooglePage;
import Screens.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;


public class TestScenarioTest extends BaseTest {
    GeneralStore generalStoreScreen;
    Product products;
    Cart cart;
    @BeforeClass
    public void initialization(){
        generalStoreScreen = new GeneralStore(driver);
    }

    @Test
    public void tc_1() throws InterruptedException {
        generalStoreScreen.clickOnShopButton() ;
        Assert.assertEquals(generalStoreScreen.getErrorMessage(), "Please enter your name");
        products = generalStoreScreen.fillForm("Andorra","Mahrous Ahmed","male");
        products.addProductsIntoCart(new String[]{ "Converse All Star","PG 3"});
        cart =  products.navigateToCartScreen();
        Assert.assertTrue(cart.priceAreEqual());
        cart.openTerms();
        GooglePage googlePage = cart.completePurchase(true);
    }



}
