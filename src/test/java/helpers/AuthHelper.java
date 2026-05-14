package helpers;

import manager.ApplicationManager;
import model.AccountData;
import org.openqa.selenium.By;

public class AuthHelper extends HelperBase {

    public AuthHelper(ApplicationManager app) {
        super(app);
    }

    public void login(AccountData user) {
        if (isLoggedIn()) {
            if (isLoggedIn(user.getEmail())) {
                return;
            }
            logout();
        }
        app.navigation().openLoginPage();
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());

        click(By.cssSelector(".btn:nth-child(4)"));
    }

    public void logout() {
        if (isLoggedIn()) {
            click(By.linkText("Logout"));
        }
    }

    public boolean isLoggedIn() {
        return driver.findElements(By.linkText("Logout")).size() > 0;
    }

    public boolean isLoggedIn(String email) {
        if (!isLoggedIn()) {
            return false;
        }
        String text = driver.findElement(
                By.xpath("//a[contains(text(),'Logged in as')]")
        ).getText();
        return text.contains(email);
    }
}
