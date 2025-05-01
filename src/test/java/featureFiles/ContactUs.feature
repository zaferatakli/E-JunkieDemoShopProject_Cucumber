Feature: Contact Form Message Sending

  Background:
    Given The user is on the homepage
    When The user clicks the Contact Us button
    And The user fills in the contact form with valid details

  Scenario: Negative scenario - Sending message without completing captcha
    And The user clicks the Send Message button without verifying captcha
    Then A Recaptcha didn't match alert should be displayed

  Scenario: Positive scenario - Sending message after completing captcha
    And The user completes the captcha verification
    And The user clicks the Send Message button
    Then A Your message has been sent successfully message should be displayed