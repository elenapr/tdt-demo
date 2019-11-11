Feature: Add to cart

#  Background:
#    Given I open the "https://www.fishingmall.ro" application

  @ui
  Scenario: As user I am able to add a product to cart
    Given I search by "lanseta"
    When I add the first product to cart
    Then The total number of the cart products is "1"

  Scenario Outline: As user I am able to add multiple products to cart
    Given I search by "<product>"
    When I add the first product to cart
    Then The total number of the cart products is "<noOfProducts>"
    Examples:
      | product | noOfProducts |
      | lanseta | 1            |
      | fire    | 2            |
      | carlig  | 3            |

