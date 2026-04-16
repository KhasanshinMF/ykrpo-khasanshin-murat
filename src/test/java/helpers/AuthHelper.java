package helpers;

import manager.ApplicationManager;
import model.AccountData;
import org.openqa.selenium.By;

public class AuthHelper extends HelperBase {

    public AuthHelper(ApplicationManager app) {
        super(app);
    }

    public void login(AccountData user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
        click(By.cssSelector(".btn:nth-child(4)"));
    }

}
