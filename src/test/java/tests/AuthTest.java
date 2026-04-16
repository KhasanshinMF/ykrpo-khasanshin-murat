package tests;

import base.TestBase;
import model.AccountData;
import org.junit.Test;

public class AuthTest extends TestBase {

    @Test
    public void login() {
        AccountData user = new AccountData("mur@gmail.com", "1234");
        app.navigation().openLoginPage();
        app.auth().login(user);
    }
}

