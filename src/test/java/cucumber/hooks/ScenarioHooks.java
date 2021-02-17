package cucumber.hooks;

import io.cucumber.java.Before;
import selenium.pages.HomePage;

public class ScenarioHooks {
    @Before(order = 1)
    public void goToURL() {
        HomePage homePage = new HomePage();
        homePage.openPage();
    }
}
