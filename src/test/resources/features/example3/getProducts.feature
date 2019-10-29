Feature: As user I am able to get all the products

  @run
  Scenario: Get all the products
    When I call the GET products with query "lanseta"
    Then a list of products is returned