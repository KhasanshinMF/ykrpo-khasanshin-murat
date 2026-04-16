import base.TestBase;
import model.AccountData;
import org.junit.Test;

public class AuthTest extends TestBase {

    @Test
    public void login() {
        AccountData user = new AccountData("mur@gmail.com", "1234");
        openLoginPage();
        login(user);
    }
}

