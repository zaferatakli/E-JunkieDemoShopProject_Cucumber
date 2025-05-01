Feature: E-Junkie -  Payment Functionality

  Scenario: Payment and confirmation by Debit/Credit Card Test
    Given Navigate to E-Junkie homepage
    And memorize the “Demo eBook” price.
    And click AddToCart for Demo eBook.
    And hit the pay by credit card button.
    When billing details page is displayed, click on the “I am a human” field
    And enter your payment details.
    And click the pay button.
    And the successful completion of the transaction.



