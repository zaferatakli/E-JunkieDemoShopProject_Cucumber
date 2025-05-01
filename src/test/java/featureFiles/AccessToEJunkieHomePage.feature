Feature: Access to E-Junkie Home Page From the Demo Shop Page

  Scenario: Accessing E-Junkie homepage
    Given Navigate to E-Junkie homepage
    When The user clicks the E-Commerce by E-Junkie link
    Then The user should be redirected to the E-Junkie copy page
    And The user clicks the E-Junkie logo
    Then The user should be redirected to the E-Junkie homepage
