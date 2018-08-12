Feature: Gmail login
  @tag1
  Scenario: validate title
    Given launch gmail site
    Then Title is "Gmail" value
    And close site

  @tag2
  Scenario Outline: validate userid
    Given launch gmail site
    When enter userid with"<u>" value
    And click next button
    Then validate userid with"<uc>" value

    Examples: 
     |   u         |     uc    |
     |*************|   valid   |
     |*************|  invalid  |
     |             |  blank    |
