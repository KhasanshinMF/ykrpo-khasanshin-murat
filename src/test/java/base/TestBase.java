package base;

import manager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;

public class TestBase {

    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = new ApplicationManager();
    }

    @After
    public void tearDown() {
        app.stop();
    }
}
