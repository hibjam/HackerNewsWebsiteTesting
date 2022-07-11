Feature: As a user, I want to be able to navigate the Hacker News website so I can find information

  Background: We will always start on the homepage
    Given I am on the homepage

  Scenario: Navigating to the comments page from the homepage
    When I click on the comments link
    Then I will go to the comments page

    Scenario: Navigating to the new page from the homepage
      When I click on the new link
      Then I will go to the new page

  Scenario: Navigating to the past page from the homepage
    When I click on the past link
    Then I will go to the past page

  Scenario: Navigating to the ask page from the homepage
    When I click on the ask link
    Then I will go to the ask page

  Scenario: Navigating to the show page from the homepage
    When I click on the show link
    Then I will go to the show page

  Scenario: Navigating to the jobs page from the homepage
    When I click on the jobs link
    Then I will go to the jobs page

  Scenario: Navigating to the submit page from the homepage
    When I click on the submit link
    Then I will go to the submit page

  Scenario: Navigating to the new login from the homepage
    When I click on the login link
    Then I will go to the login page







