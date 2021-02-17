package cucumber.stepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import selenium.pages.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UIAutomationStepDef {
    public static String customerID;
    private final static String firstName = new Faker().name().firstName();
    private final static String lastName = new Faker().name().lastName();
    private final static String postCode =new Faker().numerify("#####");


    @Given("The User in the protector anglarjs")
    public void theUserInTheHomePage() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.getPageUrl().contains("protractor-angularjs-practice-website.html"), "The protector anglarjs page not opened");
    }

    @And("click on Banking link under AngularJS Elements Lis")
    public void clickOnBankingLinkUnderAngularJSElementsLis() {
        HomePage homePage = new HomePage();
        homePage.openBankMainPage();

    }

    @When("user Clicks on Bank Manager Login")
    public void clickOnBankManagerLogin() {
        XYZBankPage xyzBankPage = new XYZBankPage();
        xyzBankPage.openBankManagerLoginPage();
    }

    @And("user Clicks on Add Customer")
    public void clickOnAddCustomer() {
        BankManagerPage bankManagerPage = new BankManagerPage();
        bankManagerPage.openAddCustomerPage();
    }

    @And("Fill all customer fields")
    public void fillAllCustomerFields() {
        AddCustomerPage addCustomerPage = new AddCustomerPage();
        Faker faker = new Faker();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode(postCode);
    }


    @And("user clicks on Add Customer Button")
    public void userClicksOnAddCustomerButton() {
        AddCustomerPage addCustomerPage = new AddCustomerPage();
        addCustomerPage.clickAddCustomerButton();
    }

    @And("Get the customer id from the alert")
    public void getTheCustomerIdFromTheAlertThenCloseTheAlert() {
        AddCustomerPage addCustomerPage = new AddCustomerPage();
        customerID = addCustomerPage.getCustomerId();
    }

    @And("user close the alert")
    public void userCloseTheAlert() {
        AddCustomerPage addCustomerPage = new AddCustomerPage();
        addCustomerPage.dismissTheAlert();
    }

    @And("user clicks on Customers Tab")
    public void clickOnCustomersTab() {
        BankManagerPage bankManagerPage = new BankManagerPage();
        bankManagerPage.openCustomersPage();
    }

    @Then("the user displayed in the same order and the data displayed correctly")
    public void theUserOrderInTheListIsTheSameAsTheValueRetrievedFromTheAlert() {
        CustomersPage customersPage = new CustomersPage();
        Map<String, String> customerData = customersPage.getAllCustomers(customerID);
        Assert.assertTrue(customerData.containsValue(firstName));
        Assert.assertTrue(customerData.containsValue(lastName));
        Assert.assertTrue(customerData.containsValue(postCode));
    }

    @Given("The User in XYZ Bank Page and click on open account")
    public void theUserInXYZBankPageAndClickOnOpenAccount() {
        BankManagerPage bankManagerPage = new BankManagerPage();
        bankManagerPage.openAccountPage();
    }

    @When("Select the customer entered in the ScenarioOne and select a random currency and Submit account by clicking on Process Button")
    public void selectTheCustomerEnteredInTheScenarioOneAndSelectARandomCurrencyAndSubmitAccountByClickingOnProcessButton() {

    }

    @And("Get the Account Number from the Alert then close the alert")
    public void getTheAccountNumberFromTheAlertThenCloseTheAlert() {
    }

    @And("Click on Customers")
    public void clickOnCustomers() {
        BankManagerPage bankManagerPage = new BankManagerPage();
        bankManagerPage.openCustomersPage();
    }

    @Then("Assert that the Account Number retrieved from the alert is displayed in its cell for the created customer")
    public void assertThatTheAccountNumberRetrievedFromTheAlertIsDisplayedInItsCellForTheCreatedCustomer() {
//        Assert.assertTrue();
    }

    @Given("The User in XYZ Bank Customers Tab")
    public void theUserInXYZBankCustomersTab() {
        BankManagerPage bankManagerPage = new BankManagerPage();
        bankManagerPage.openCustomersPage();
    }

    @When("Click on Delete for the created customer in the scenarioOne")
    public void clickOnDeleteForTheCreatedCustomerInTheScenarioOne() {
        CustomersPage customersPage = new CustomersPage();
        customersPage.deleteAccount();
    }

    @Then("Assert that the customer is no longer found in the customers' table")
    public void assertThatTheCustomerIsNoLongerFoundInTheCustomersTable() {
//        Assert.assertTrue();
    }
}
