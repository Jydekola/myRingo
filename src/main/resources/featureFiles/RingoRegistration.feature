@Register
Feature: Register for Ringo account
#@Register
  Scenario Outline: Register for a Ringo account (Happy path)
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
  Then sms verification page is displayed

    Examples:
    |MobileNumber|EmailAddress|Password|
    |0782828292|ringo1@email.com|Pazzword1|

  Scenario Outline: Register for a Ringo account with no PhoneNumber
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "Mobile number is required" msg is displayed under the "<MobileNumber>" field

    Examples:
      |MobileNumber|EmailAddress|Password|
      ||ringo1@email.com|Pazzword1|


  Scenario Outline: Register for a Ringo account with no Email address
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "Email address is required" msg is displayed under the "<EmailAddress>" field

    Examples:
      |MobileNumber|EmailAddress|Password|
      |078383982991||Pazzword1|


  Scenario Outline: Register for a Ringo account with no Password
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "Password is required" msg is displayed under the "<Password>" field

    Examples:
      |MobileNumber|EmailAddress|Password|
      |078383982991|emaisl@emi.com||

  Scenario Outline: Register for a Ringo account without accepting Terms and Conditions
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "You must agree to the Terms & Conditions" msg is displayed under the Terms and Conditions

    Examples:
      |MobileNumber|EmailAddress|Password|
      |078383982991|emaisl@emi.com|Pazzword1|

  Scenario Outline: Register for a Ringo account with PhoneNumber of 9 characters
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "Telephone number must be longer than 9 characters" msg is displayed under the "<MobileNumber>" field

    Examples:
      |MobileNumber|EmailAddress|Password|
      |012345678|ringo1@email.com|Pazzword1|


  Scenario Outline: Register for a Ringo account with invalid email address
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "Email address is invalid." msg is displayed under the "<EmailAddress>" field

    Examples:
      |MobileNumber|EmailAddress|Password|
      |012345678|ringo1@email|Pazzword1|
      |012345678|ringo14|Pazzword1|


  Scenario Outline: Register for a Ringo account with invalid password
    Given I am on a the Ringo Registration Home screen "http://myrgo-preprod.ctt.co.uk/register"
    When I enter valid "<MobileNumber>", "<EmailAddress>" and "<Password>"
    And I tick option to get emails
    And I tick option to share my info with third party partners
    And I agree to the Terms and Conditions and Privacy option
    And I click Next button
    Then error in the form is dispalyed
    And "The password does not meet the correct format." msg is displayed under the "<Password>" field

    Examples:
      |MobileNumber|EmailAddress|Password|
      |012345678|ringo1@email.com|password|
      |012345678|ringo2@email.com|password1|
      |012345678|ringo3@email.com|Password|
      |012345678|ringo3@email.com|PASSWORD|