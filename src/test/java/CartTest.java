import base.TestBase;
import org.junit.Test;

public class CartTest extends TestBase {

    @Test
    public void addProductToCart() {
        openProductsPage();
        addFirstProductToCart();
        confirmAddToCart();
    }
}
