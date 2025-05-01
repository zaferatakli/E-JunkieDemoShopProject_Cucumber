Feature:I tried to pay with incomplete information from the Demo Shop

  Scenario:  Checkout ‘Demo eBook’ purchase test
    Given Navigate to E-Junkie homepage
    And click AddToCart for Demo eBook.
    And hit the pay by credit card button.
    And click the pay button.
    Then The user should see the invalid messages