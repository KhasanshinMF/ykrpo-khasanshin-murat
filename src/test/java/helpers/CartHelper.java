package helpers;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartHelper extends HelperBase{

    public CartHelper(ApplicationManager app) {
        super(app);
    }

    public void addFirstProductToCart() {
        By product = By.cssSelector(".col-sm-4:nth-child(3)");
        new Actions(driver)
                .moveToElement(driver.findElement(product))
                .perform();
        click(By.cssSelector(".col-sm-4:nth-child(3) .add-to-cart"));
    }

    public void confirmAddToCart() {
        By modalButton = By.cssSelector(".modal-content .btn-success");
        wait.until(ExpectedConditions.elementToBeClickable(modalButton));
        click(modalButton);
    }

    public void removeProductFromCart() {
        By deleteButton = By.cssSelector(".fa-times");
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        click(deleteButton);
    }

    public boolean isCartEmpty() {
        return driver.findElements(By.cssSelector(".cart_info")).isEmpty()
                || driver.getPageSource().contains("Cart is empty");
    }

    public boolean isProductAdded() {
        return driver.findElements(By.cssSelector(".modal-content")).size() > 0;
    }
}
