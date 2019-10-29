Feature: Search

  Scenario: As user I am able to search
    Given I open the application "https://www.fishingmall.ro"
    When I search by "lanseta"
    Then I get a list of products