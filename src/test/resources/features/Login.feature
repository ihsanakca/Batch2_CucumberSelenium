@login
Feature: Krafttech Log in test
  # As a user, I should be able to login so I can see my account

  Background:
    Given The user should be able to login page

  @Selim @smoke
  Scenario: Login as Selim
    When The user enters Selim credentials
    Then The user should be able to login

  @Mike  @SDET @smoke
  Scenario: Login as Mike
    When The user enters Mike credentials
    Then The user should be able to login

    #class Task user enters Jhon Nash credentials
  @SDET  @developer
  Scenario: Login as Jhon Nash
    When The user enters Jhon Nash credentials
    Then The user should be able to login

  @developer @smoke @QA
  Scenario: Login as Rosa
    When The user enters Rosa credentials
    Then The user should be able to login


  Scenario: User  should be able to login with valid credentials
    When User should input login information
    Then User should be on home page

  Scenario: Login with parameters
    When User should input "user22@test.com" and "Test123456"
    Then User should be on home page

  Scenario: Login as a given user
    Then User should input  following credentials
      | email    | user22@test.com |
      | password | Test123456      |
      | Name     | User22          |

  Scenario Outline: Data Table and scenario outline
    Then User should input  following credentials
      | email    | <userEmail> |
      | password | <password>  |
      | Name     | <userName>  |

    Examples:
      | userEmail        | password   | userName     |
      | user22@test.com  | Test123456 | User22       |
      | sgezer@gmail.com | 12345678   | Selim Gezer  |
      | eddiem@kraft.com | eddiem12  | Eddie Murphy |


  Scenario: Try to login with no parameters
    When User should input "" and ""
    Then The user should be able to see "Please enter your email." and "Please enter your password!" and "" warning message

  Scenario: Try to login with no email
    When User should input "" and "12345678"
    Then The user should be able to see "Please enter your email." and "" and "" warning message

  Scenario: Try to login with no password
    When User should input "sgezer@gmail.com" and ""
    Then The user should be able to see "" and "Please enter your password!" and "" warning message

  Scenario: Try to login with wrong email
    When User should input "sgezer61@gmail.com" and "12345678"
    Then The user should be able to see "" and "" and "Email address or password is incorrect. Please check" warning message

  Scenario: Try to login with wrong password
    When User should input "sgezer@gmail.com" and "1234567861"
    Then The user should be able to see "" and "" and "Email address or password is incorrect. Please check" warning message

  Scenario: Try to login with wrong email and wrong password
    When User should input "sgezer61@gmail.com" and "1234567861"
    Then The user should be able to see "" and "" and "Email address or password is incorrect. Please check" warning message

  Scenario Outline: Negative login tests
    When User should input "<userEmail>" and "<password>"
    Then The user should be able to see "<warningMsg1>" and "<warningMsg2>" and "<warningMsg>" warning message

    Examples:
      | userEmail          | password   | warningMsg1              | warningMsg2                 | warningMsg                                           |
      |                    |            | Please enter your email. | Please enter your password! |                                                      |
      |                    | 12345678   | Please enter your email. |                             |                                                      |
      | sgezer@gmail.com   |            |                          | Please enter your password! |                                                      |
      | sgezer61@gmail.com | 12345678   |                          |                             | Email address or password is incorrect. Please check |
      | sgezer@gmail.com   | 1234567861 |                          |                             | Email address or password is incorrect. Please check |
      | sgezer@gmail61.com | 1234567861 |                          |                             | Email address or password is incorrect. Please check |