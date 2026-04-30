package helpers;

import manager.ApplicationManager;

public class NavigationHelper extends HelperBase{

    private final String BASE_URL = "https://automationexercise.com";

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void openLoginPage() {
        driver.get(BASE_URL + "/login");
    }

    public void openProductsPage() {
        driver.get(BASE_URL + "/products");
    }

    public void openCartPage() {
        driver.get(BASE_URL + "/view_cart");
    }
}
