package tests;

import base.TestBase;
import model.ProductData;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Assert;

public class CartTest extends TestBase {

    @ParameterizedTest
    @MethodSource("providers.DataProviders#productDataFromXml")
    public void addProductToCart(ProductData product) {
        app.navigation().openProductsPage();
        app.cart().addProductToCartByName(product.getName());
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
