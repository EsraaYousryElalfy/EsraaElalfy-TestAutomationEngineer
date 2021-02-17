Feature: Add and Delete Customer

  Scenario: scenarioOne
    Given The User in the protector anglarjs
    And click on Banking link under AngularJS Elements Lis
    And user Clicks on Bank Manager Login
    And user Clicks on Add Customer
    And Fill all customer fields
    And user clicks on Add Customer Button
    And Get the customer id from the alert
    And user close the alert
    And user clicks on Customers Tab
    Then the user displayed in the same order and the data displayed correctly

  Scenario: scenarioTwo
    Given The User in XYZ Bank Page and click on open account
    When Select the customer entered in the ScenarioOne and select a random currency and Submit account by clicking on Process Button
    And Get the Account Number from the Alert then close the alert
    And Click on Customers
    Then Assert that the Account Number retrieved from the alert is displayed in its cell for the created customer

  Scenario: scenarioThree
    Given The User in XYZ Bank Customers Tab
    When Click on Delete for the created customer in the scenarioOne
    Then Assert that the customer is no longer found in the customers' table

