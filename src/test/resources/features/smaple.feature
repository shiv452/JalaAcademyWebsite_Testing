#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background: Validating the Login is working
    Given brower is open
    When user is on Jala Academy login page
    And user is type the username and password
    Then hit the login button

  Scenario: Validating the popups tab and its functionality
    When user click on the more
    And click on the popups sub-tab
    And Check the first three popups and print the message
    And Check the second three popups and print the message
    And Check the third three popups and print the message
