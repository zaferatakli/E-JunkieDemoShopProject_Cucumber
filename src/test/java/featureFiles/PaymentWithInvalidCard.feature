Feature: Payment with invalid card number

  Scenario: Checkout process with invalid credit card number
    Given Navigate to E-Junkie homepage
    And click AddToCart for Demo eBook.
    And hit the pay by credit card button.
    When billing details page is displayed, click on the “I am a human” field
    And The user enter payment details and invalid card number.
    And The user clicks the Make Payment button
    Then The user should see the message Your card number is invalid