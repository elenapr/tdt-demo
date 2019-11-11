Feature: As user I am able to get all the products

  @rest
  Scenario: Get all the products
    Given I call the GET resource
    Then an html result is returned
    And the status code is 200
    And the content type is "text/html; charset=UTF-8"