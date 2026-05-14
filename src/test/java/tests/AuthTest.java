package tests;

import base.TestBase;
import model.AccountData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import utils.Settings;

public class AuthTest extends TestBase {

    @Test
    public void loginWithValidData() {
        app.auth().logout();
        AccountData user = new AccountData(Settings.getLogin(), Settings.getPassword());
        app.auth().login(user);
        Assertions.assertTrue(app.auth().isLoggedIn());
    }

    @Test
    public void loginWithInvalidData() {
        app.auth().logout();
        AccountData user = new AccountData("wrong@mail.test", "wrong password");
        app.auth().login(user);
        Assertions.assertFalse(app.auth().isLoggedIn());
    }
}

