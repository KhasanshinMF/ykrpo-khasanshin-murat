package tests;

import base.TestBase;
import org.junit.Test;

public class CartTest extends TestBase {

    @Test
    public void addProductToCart() {
        app.navigation().openProductsPage();
        app.cart().addFirstProductToCart();
        app.cart().confirmAddToCart();
    }
}
