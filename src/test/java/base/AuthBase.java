package base;

import model.AccountData;
import org.junit.jupiter.api.BeforeEach;
import utils.Settings;

public class AuthBase extends TestBase {
    @BeforeEach
    public void setUpAuth() {

        AccountData user = new AccountData(
                Settings.getLogin(),
                Settings.getPassword()
        );

        app.auth().login(user);
    }
}
