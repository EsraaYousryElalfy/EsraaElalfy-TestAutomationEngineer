package selenium.pages;

import cucumber.hooks.GlobalHooks;
import selenium.driver.SeleniumWebDriver;

import static selenium.locatores.HomePageLocator.*;

public class AddCustomerPage extends GlobalHooks {


    public void enterFirstName(String firstName) {
        SeleniumWebDriver.sendKeys(First_Name.by(),firstName);
    }
    public void enterLastName(String lastName) {
        SeleniumWebDriver.sendKeys(Last_Name.by(),lastName);
    }
    public void enterPostCode(String postCode) {
        SeleniumWebDriver.sendKeys(Post_Code.by(),postCode);
    }
    public void clickAddCustomerButton() {
        SeleniumWebDriver.clickOn(Add_Customer.by());
    }

    public String getCustomerId() {
        String alertText = SeleniumWebDriver.getTextFromAlert();
        return alertText.substring(alertText.indexOf(":") + 1);
    }

    public void dismissTheAlert() {
        SeleniumWebDriver.dismissAlert();
    }
}
