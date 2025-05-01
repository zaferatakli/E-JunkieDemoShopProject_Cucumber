Feature: Navigating to E-Junkie from Demo Shop

  Scenario: User accesses the homepage through the site navigation
    Given Navigate to E-Junkie homepage
    When The user clicks the E-Commerce by E-Junkie link
    Then The user should be redirected to the E-Junkie copy page
    And The user clicks the E-Junkie logo
    Then The user should be redirected to the E-Junkie homepage
