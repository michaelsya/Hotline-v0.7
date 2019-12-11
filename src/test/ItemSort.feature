Feature: Sort items
  Scenario: Sort items by price (ascending)
    Given  I am on the "https:\\hotline.ua" website
    When  I enter "телевизор" in the search field
    And click on search
    And select sort by "возрастанию цены" dropdown option
    Then I see no prices higher than "10000" on the first "5" pages