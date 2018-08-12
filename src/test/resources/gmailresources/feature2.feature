
Feature: Gmail login
  I want to use this template for my feature file
Scenario Outline: validate password
    Given launch gmail site
    When enter userid with "************" value
    And click next button
    And enter password with "<P>" value
    And click password next button
    Then validate passwor with "<pc>" criteria

    Examples: 
      |    p      |       pc    |
      |***********|     valid   |
      |***********|   invalid   |
      |           |   blank     |
      
      
      
      
      
      
      
      
      