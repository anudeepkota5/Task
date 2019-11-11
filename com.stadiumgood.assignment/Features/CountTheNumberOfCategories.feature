Feature: Count the Number of Catagories in Header, select A Random Catagory and filter low to high

  @countTheNumberOfCatagories
  Scenario: Counting the number of catagories in the Header
    Given User logins into the application with propert credentials
    Then User Counts the number of catagories in the header

  @userClickOnParticalCatagory
  Scenario: Select a Random Catagori and Filter low to high
    Given User Selects Jordan
    Then User Sort By low to high
