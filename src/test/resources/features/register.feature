Feature: Demo Register User

  Background:
    Given user on the homepage

  @regression @register
  Scenario: Register User
    Then verify that home page is visible successfully
    When click on sign up or login button
    Then verify new user signup is visible
    When fill name and email address on sign up page
    And click sign up button on sign up page
    And fill details user information on sign up page
    And select checkbox sign up for our newsletter and receive special offers from our partners
    And fill user address information on sign up page
    And click create account button on sign up page
    Then verify that account created text is visible