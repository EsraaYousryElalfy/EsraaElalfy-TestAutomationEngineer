package selenium.pages;

import constants.SystemProperties;
import cucumber.hooks.GlobalHooks;
import selenium.driver.SeleniumWebDriver;

import static selenium.locatores.HomePageLocator.Banking_Link;

public class HomePage extends GlobalHooks {

    public void openPage() {
        SeleniumWebDriver.openPage(SystemProperties.getSeleniumURL());
    }
    public void openBankMainPage() {
        SeleniumWebDriver.waitVisibilityOfElement(Banking_Link.by(),20);
        SeleniumWebDriver.scrollToElement(Banking_Link.by());
        SeleniumWebDriver.moveMouseToElement(Banking_Link);
        SeleniumWebDriver.clickOn(Banking_Link.by());
    }

    public String getPageUrl() {
        return SeleniumWebDriver.getUrl();
    }
}
