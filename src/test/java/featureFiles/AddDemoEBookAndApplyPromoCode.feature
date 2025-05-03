Feature: Add Demo E-Book to Basket and Apply Invalid Promo Code

  Scenario: Add demo e-book and apply an invalid promo code
    Given Navigate to E-Junkie homepage
    And click AddToCart for Demo eBook.
    When The user clicks the Add Promo Code button
    And The user enters an invalid promo code
    Then The user should see an Invalid promotional code warning message