Feature: As a user, I want to be able see 30 different items on every page after I click the more button on the bottom so I  can view different links
  Background: Each of the main links at the top of the HN page (except submit and login) should have 30 items on each page, after clicking on the more button at the bottom
    Given I am on the HN Website

  Scenario: Clicking the more button at the bottom of any valid page should produce a different 30 items
    When I navigate to a page containing different items and click more
    Then I should be able to see a different thirty items on the page

    Scenario: After clicking the more button, the next item should be item 31 (except on the comments page)
    When I navigate to a page containing different items and click more
    Then The next item on the list should be item 31
