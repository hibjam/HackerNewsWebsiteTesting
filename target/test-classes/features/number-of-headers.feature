Feature: As a user, I want to be able see 30 items on every page so I  can view a range of links
  Background: Each of the main links at the top of the HN page (except submit and login) should have 30 items on each page
    Given I am on the HN Website

    Scenario: Checking to see if there are 30 items on any valid page
    When I navigate to a page containing different items
    Then I should be able to see 30 items per page

