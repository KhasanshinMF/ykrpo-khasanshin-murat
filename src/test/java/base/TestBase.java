package base;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected ApplicationManager app;

    @BeforeEach
    public void setUp() {
        app = ApplicationManager.getInstance();
    }
}
