package base;

import model.AccountData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;

    private final String BASE_URL = "https://automationexercise.com";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void openLoginPage() {
        driver.get(BASE_URL + "/login");
        driver.manage().window().setSize(new Dimension(756, 949));
    }

    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void login(AccountData user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
        click(By.cssSelector(".btn:nth-child(4)"));
    }

    public void openProductsPage() {
        driver.get(BASE_URL + "/products");
        driver.manage().window().setSize(new Dimension(1472, 910));
    }

    public void addFirstProductToCart() {
        By product = By.cssSelector(".col-sm-4:nth-child(3)");
        hover(product);
        click(By.cssSelector(".col-sm-4:nth-child(3) .add-to-cart"));
    }

    public void confirmAddToCart() {
        By modalButton = By.cssSelector(".modal-content .btn-success");
        wait.until(ExpectedConditions.elementToBeClickable(modalButton));
        click(modalButton);
    }

    public void hover(By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .perform();
    }
}
