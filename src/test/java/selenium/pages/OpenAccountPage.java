package selenium.pages;

import cucumber.hooks.GlobalHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.driver.SeleniumWebDriver;

import java.util.List;

import static selenium.locatores.HomePageLocator.*;

public class OpenAccountPage extends GlobalHooks {

    public void selectCustomer(String option) {
        SeleniumWebDriver.clickOn(Customers_List.by());
        SeleniumWebDriver.selectFromListByValue(Customers_List.by(), option);
    }

    public void selectCurrency() {
        SeleniumWebDriver.clickOn(Currency_List.by());
        SeleniumWebDriver.selectRandomlyFromDropList(Currency_List_Options.by());

    }

    public void clickOnProcess() {
        SeleniumWebDriver.clickOn(Process_Button.by());
    }

    public String getNumberFromAlert() {
        String alertText = SeleniumWebDriver.getTextFromAlert();
        return alertText.substring(alertText.indexOf(":") + 1);
    }

    public void dismissTheAlert() {
        SeleniumWebDriver.dismissAlert();
    }
}
