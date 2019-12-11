Feature: Item Search
  Scenario: Search an item and check its description
    Given I am on the "https:\\hotline.ua" website
    When  I enter "телевизор" in the search field
    And click on search
    And I click on the first item in the list on a search result page
    Then I see a word "телевизор" in the item description
