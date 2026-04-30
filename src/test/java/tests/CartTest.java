package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class CartTest extends TestBase {

    @Test
    public void addProductToCart() {
        app.navigation().openProductsPage();
        app.cart().addFirstProductToCart();
        app.cart().confirmAddToCart();

        Assert.assertTrue(app.cart().isProductAdded());
    }

    @Test
    public void removeProductFromCart() {
        app.navigation().openProductsPage();
        app.cart().addFirstProductToCart();
        app.cart().confirmAddToCart();

        app.navigation().openCartPage();
        app.cart().removeProductFromCart();

        Assert.assertTrue(app.cart().isCartEmpty());
    }
}
