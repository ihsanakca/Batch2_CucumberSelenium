@login
Feature: Krafttech Log in test
  # As a user, I should be able to login so I can see my account

  @Selim @smoke
  Scenario: Login as Selim
    Given The user is on the login page
    When The user enters Selim credentials
    Then The user should be able to login

  @Mike  @SDET @smoke
  Scenario: Login as Mike
    Given The user is on the login page
    When The user enters Mike credentials
    Then The user should be able to login

    #class Task user enters Jhon Nash credentials
  @SDET  @developer
  Scenario: Login as Jhon Nash
    Given The user is on the login page
    When The user enters Jhon Nash credentials
    Then The user should be able to login

  @developer @smoke @QA
  Scenario: Login as Rosa
    Given The user is on the login page
    When The user enters Rosa credentials
    Then The user should be able to login

