package selenium.pages;

import cucumber.hooks.GlobalHooks;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.driver.SeleniumWebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static selenium.locatores.HomePageLocator.*;

public class CustomersPage extends GlobalHooks {


    public Map<String, String> getAllCustomers(String id) {
        Map<String, String> customerData = new HashMap<>();
        List<WebElement> key = driver.findElement(Customers_Table_Header.by()).findElements(By.xpath("./td"));
        List<WebElement> value = driver.findElement(Customers_Table_Data.by()).findElement(By.xpath("./tr[" + id + "]")).findElements(By.xpath("./td"));
        for (int i = 0; i < value.size(); i++) {
            customerData.put(key.get(i).getText(), value.get(i).getText());
        }
        return customerData;
    }

    public List<Map<String, String>> getAllCustomers() {
        Map<String, String> customerData = new HashMap<>();
        List<Map<String,String>> listCustomers = new ArrayList<>();
        List<WebElement> key = driver.findElement(Customers_Table_Header.by()).findElements(By.xpath("./td"));
        List<WebElement> rows = driver.findElement(Customers_Table_Data.by()).findElements(By.xpath("./tr"));
        for (WebElement row : rows) {
            List<WebElement> value = row.findElements(By.xpath("./td"));
            for (int j = 0; j < value.size(); j++) {
                customerData.put(key.get(j).getText(), value.get(j).getText());
            }
            listCustomers.add(customerData);
        }
        return listCustomers;
    }

    public void searchAboutCustomer(String customer) {
        SeleniumWebDriver.waitVisibilityOfElement(Customer_Search.by(), 20);
        SeleniumWebDriver.sendKeysAndClear(Customer_Search.by(), customer);
    }

    public void deleteAccount() {
        SeleniumWebDriver.clickOn(Delete_Button.by());
    }
}
