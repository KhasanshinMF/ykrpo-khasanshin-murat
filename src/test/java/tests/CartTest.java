package tests;

import base.AuthBase;
import model.ProductData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class CartTest extends AuthBase {

    @ParameterizedTest
    @MethodSource("providers.DataProviders#productDataFromXml")
    public void addProductToCart(ProductData product) {
        app.navigation().openProductsPage();
        app.cart().addProductToCartByName(product.getName());
        app.cart().confirmAddToCart();

        Assertions.assertTrue(app.cart().isProductAdded());
    }

    @Test
    public void removeProductFromCart() {
        app.navigation().openProductsPage();
        app.cart().addFirstProductToCart();
        app.cart().confirmAddToCart();

        app.navigation().openCartPage();
        app.cart().removeProductFromCart();

        Assertions.assertTrue(app.cart().isCartEmpty());
    }
}
