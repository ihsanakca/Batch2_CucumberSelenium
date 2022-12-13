Feature: Negative Login Test

  @negativeLogin
  Scenario Outline:
    Given The user should be able to login page
    When User should input "<userEmail>" and "<password>"
    Then  The warning message contains "<message>"

    Examples:
      | userEmail        | password      | message                                              |
      | sgezer@gmail.com | wrongpassword | Email address or password is incorrect. Please check |
      | wrong@gmail.com  | 12345678      | Email address or password is incorrect. Please check |
      | sgezer@gmailcom  | 12345678      | Email address or password is incorrect. Please check |
      | sgezergmail.com  | 12345678      | Email address or password is incorrect. Please check |
      |                  | 12345678      | Please enter your email.                             |
      | sgezer@gmail.com |               | Please enter your password!                          |
      |                  |               | Please enter your password!                          |