Feature: Validate if the user is able to login using the user credentials.

  @validateLogin
  Scenario: Validation of Credentials from the Excel Sheet
    Given User retrives User Names from the excel and validates
    Then User retrieves Password from the excel and validates

  @APIValidation
  Scenario: Pokemon API Validation testing against Excel data
    Given Excel Data Pull
    When Pokemon API data Pull and Validate API
