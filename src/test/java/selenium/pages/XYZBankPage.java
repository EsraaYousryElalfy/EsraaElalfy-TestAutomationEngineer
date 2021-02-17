package selenium.pages;

import cucumber.hooks.GlobalHooks;
import selenium.driver.SeleniumWebDriver;

import static selenium.locatores.HomePageLocator.Bank_Manager_Login_Button;
import static selenium.locatores.HomePageLocator.Banking_Link;

public class XYZBankPage extends GlobalHooks {


    public void openBankManagerLoginPage() {
        SeleniumWebDriver.switchTab("Protractor practice website - Banking App");
        SeleniumWebDriver.waitVisibilityOfElement(Bank_Manager_Login_Button.by(),120);
        SeleniumWebDriver.clickOn(Bank_Manager_Login_Button.by());
    }
}
