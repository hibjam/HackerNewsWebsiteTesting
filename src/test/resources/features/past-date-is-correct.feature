Feature: As a user, I want to be able to see the correct past date being displayed for the news stories when I click on the past page
  Background: Each item on each page should have a corresponding href link
    Given I am on the HN website

    Scenario: on the new page, clicking an item should take you to that story
      When I click on a displayed item
      Then I should be redirected to a news article
