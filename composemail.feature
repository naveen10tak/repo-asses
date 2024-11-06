composemail.feature

Feature: Compose Email Function in Gmail

  Background:
    Given the user is logged into their Gmail account

  @PositiveTest
  Scenario: Successfully compose and send an email
    When the user clicks on the compose button
    And the user enters "recipient@example.com" in the "To" field
    And the user enters "Test Subject" in the subject field
    And the user enters "This is a test email body" in the email body
    And the user clicks on the send button
    Then the email should be sent successfully
    And a confirmation message should be displayed

  @NegativeTest
  Scenario: Compose email without recipient
    When the user clicks on the compose button
    And the user leaves the "To" field empty
    And the user enters "Test Subject" in the subject field
    And the user enters "This is a test email body" in the email body
    And the user clicks on the send button
    Then an error message should be displayed saying "Please specify at least one recipient."

  @NegativeTest
  Scenario: Compose email with invalid recipient address
    When the user clicks on the compose button
    And the user enters "invalid-email" in the "To" field
    And the user enters "Test Subject" in the subject field
    And the user enters "This is a test email body" in the email body
    And the user clicks on the send button
    Then an error message should be displayed saying "The email address is invalid."
