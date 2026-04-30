package manager;

import helpers.AuthHelper;
import helpers.CartHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();
    private WebDriver driver;

    private NavigationHelper navigationHelper;
    private AuthHelper authHelper;
    private CartHelper cartHelper;

    private ApplicationManager() {
        driver = new FirefoxDriver();
        navigationHelper = new NavigationHelper(this);
        authHelper = new AuthHelper(this);
        cartHelper = new CartHelper(this);
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();

    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper navigation() {
        return navigationHelper;
    }

    public AuthHelper auth() {
        return authHelper;
    }

    public CartHelper cart() {
        return cartHelper;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
