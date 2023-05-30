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

  @tag1
  Scenario: Validating the collapes content page
    When user click on the more
    And click on the collapsible content
    And click to the multiple collapes
    And click all collapes in sequence
    And click to close all collapes
    And click first and close
    And click second and close
    And click third and close
    And click fourth and close
    Then click to the single collapes
    And click first and close1
    And click second and close2
    And click third and close3
    And click all three in sequence
