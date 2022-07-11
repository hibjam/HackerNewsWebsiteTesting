Feature: As a user, I want each item on a page to contain a valid link so it can direct me to a valid site
  Background: Will always start from from the homepage and try links there first, can navigate to a different page if needed
    Given I am on the homepage
    Scenario: clicking a on one of the items will redirect you to a valid site

    When I click on one of them items on the page
    Then The link will be valid and redirect me to a valid site