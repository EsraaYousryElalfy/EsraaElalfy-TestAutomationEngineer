Feature: Add and Delete Customer

  Background:
    Given The User in the protector anglarjs
    And click on Banking link under AngularJS Elements Lis
    And user Clicks on Bank Manager Login
    And user Clicks on Add Customer
    And Fill all customer fields
    And user clicks on Add Customer Button
    And Get the customer id from the alert
    And user close the alert

  Scenario: scenarioOne
    When user clicks on Customers Tab
    Then the user displayed in the same order abd the data displayed correctly

  Scenario: scenarioTwo
    Given user Clicks on open account
    And Select the customer entered in the ScenarioOne and select a random currency and Submit account by clicking on Process Button
    And Get the Account Number from the Alert then close the alert
    When Click on Customers
    Then the Account Number retrieved from the alert is displayed in its cell for the created customer

  Scenario: scenarioThree
    Given user clicks on Customers Tab
    When Click on Delete for the created customer in the scenarioOne
    Then the customer is no longer found in the customers table

