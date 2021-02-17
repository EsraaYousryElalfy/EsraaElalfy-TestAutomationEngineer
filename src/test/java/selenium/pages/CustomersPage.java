package selenium.pages;

import cucumber.hooks.GlobalHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.driver.SeleniumWebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static selenium.locatores.HomePageLocator.*;

public class CustomersPage extends GlobalHooks {
    String CustomersFirstPart = "//table[@class='table table-bordered table-striped']/thead/tr[";
    String CustomersSecondPart = "]/td[";
    String CustomersThirdPart = "]";

    public void deleteAccount() {
        SeleniumWebDriver.clickOn(Delete_Button.by());
    }

    public Map<String, String> getAllCustomers(String id) {
        Map<String,String> customerData= new HashMap<String,String>();
        List<WebElement> key = driver.findElement(Customers_Table_Header.by()).findElements(By.xpath("./td"));
        List<WebElement> value = driver.findElement(Customers_Table_Data.by()).findElement(By.xpath("./tr["+id+"]")).findElements(By.xpath("./td"));
        for (int i =0;i<value.size();i++){
            customerData.put(key.get(i).getText(),value.get(i).getText());
        }
        return customerData;
    }






}
