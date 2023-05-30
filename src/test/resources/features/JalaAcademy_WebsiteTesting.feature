Feature: Feature to test the Jala Academy

  Background: Validating the Login is working
    Given brower is open
    When user is on Jala Academy login page
    And user is type the username and password
    Then hit the login button

  @test-1
  Scenario: Validating the page is working
    When user click the employee tab
    And user click the create tab
    Then user click the home

  @test-2
  Scenario: Validating the Employee Page
    When user click the create form tab
    And user type the First Name
    And user type the Last Name
    And user type the Email
    And user type the Mobile Number
    And user select the Date of Birth
    And user type the Address
    And user select the Country
    And user select the City
    And user select the Skills
    Then user hit the save button

  @test-3
  Scenario: Validating the Search Page
    When click on the employee tab then search tab
    And type the name in name input
    And click on seach button
    And if page found print the message
    And click on clear button
    And type mobile number in input
    And click on the search button
    And click on the edit button
    And if page open print the message
    And click on the cancel button
    Then search name and delete the page

  @test-4
  Scenario: Validating the more option tab and checking the functionality of sub tab multiple tabs
    When the user click on the more tab
    And click on sub-tab multiple
    And click on the Ways of Unlearning
    And type the text_first
    And click on the UnLearning
    And type the text_second
    And click on the Plan to Succeed
    And type the text_third
    Then click to the home page tab

  @test-5
  Scenario: Validating the more option and checking the functionality of the menu
    When user click on the more
    And click on the menu
    And click Sub-Menus
    And click on the Testing
    And click on the drop down option Testing and print
    And click on the JAVA
    And click on the drop down option Java and print
    And click on the .NET
    And click on the drop down option Net and print
    And click on the Database
    And click on the drop down option Database and print
    And click on the Single Menus
    Then click on the Testing, Java, .Net, Data Base

  @test-6
  Scenario: Validating the more option and checking the functionality of sub tab autocomplete
    When user click on the more1
    And click on the autocomplete tab
    And click on the multiple values
    And type multiple language
    And click on the single values
    Then type single language
