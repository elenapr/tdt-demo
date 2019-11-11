Feature: As user I am able to search

  Scenario: As user I am able to search for a product
    Given I open the "https://www.fishingmall.ro/ro" application
    Then the application is successfully opened

  Scenario Outline: Search by different products
    Given I open the "https://www.fishingmall.ro/ro" application
    When I search by "<product>"
    Then A list of products is returned
    Examples:
      | product |
      | lanseta |
      | plasa   |
      | momeala |
      | ac      |