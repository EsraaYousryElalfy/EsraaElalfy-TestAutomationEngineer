package selenium.pages;

import cucumber.hooks.GlobalHooks;
import selenium.driver.SeleniumWebDriver;

import static selenium.locatores.HomePageLocator.*;

public class BankManagerPage extends GlobalHooks {


    public void openAddCustomerPage() {
        SeleniumWebDriver.clickOn(Add_Customer_Button.by());
    }
    public void openAccountPage() {
        SeleniumWebDriver.clickOn(Open_Account_Button.by());
    }
    public void openCustomersPage() {
        SeleniumWebDriver.clickOn(Open_Customers_Button.by());
    }

}
