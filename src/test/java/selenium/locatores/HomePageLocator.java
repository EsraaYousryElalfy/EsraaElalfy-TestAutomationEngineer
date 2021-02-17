package selenium.locatores;

import constants.Locator;
import org.openqa.selenium.By;

public enum HomePageLocator implements Locator {
    //HOME_ICON (By.xpath("")),
    Banking_Link(By.xpath("//ul[@class='boxed_style block']/li[6]")),
    Bank_Manager_Login_Button(By.xpath("//button[text()='Bank Manager Login']")),
    Add_Customer_Button(By.xpath("//button[contains(text(),'Add Customer')]")),
    Open_Account_Button(By.xpath("//button[contains(text(),'Open Account')]")),
    Open_Customers_Button(By.xpath("//button[contains(text(),'Customers')]")),
    First_Name(By.xpath("//input[@placeholder='First Name']")),
    Last_Name(By.xpath("//input[@placeholder='Last Name']")),
    Post_Code(By.xpath("//input[@placeholder='Post Code']")),
    Add_Customer(By.xpath("//button[@type='submit']")),
    Delete_Button(By.xpath("//button[contains(text(),'Delete')]")),
    Customers_Table_Header(By.xpath("//table[@class='table table-bordered table-striped']/thead/tr")),
    Customers_Table_Data(By.xpath("//table[@class='table table-bordered table-striped']/tbody")),
    Customers_List(By.id("userSelect")),
    Currency_List(By.id("currency")),
    Currency_List_Options(By.xpath("//select[@id='currency']/option")),
    Process_Button(By.xpath("//button[@type='submit']")),
    Customer_Search(By.xpath("//input[@placeholder='Search Customer']")),
    ;

    private By locator;


    HomePageLocator(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }
}
