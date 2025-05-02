Feature: E-Junkie - Payment Functionality With Missing Information

  Scenario: Payment and confirmation by Debit/Credit Card Test
    Given Navigate to E-Junkie homepage
    And click AddToCart for Demo eBook.
    And hit the pay by credit card button.
    Then The user should see the invalid messages