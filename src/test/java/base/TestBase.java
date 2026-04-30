package base;

import manager.ApplicationManager;
import org.junit.Before;

public class TestBase {

    protected ApplicationManager app;

    @Before
    public void setUp() {
        app = ApplicationManager.getInstance();
    }
}
