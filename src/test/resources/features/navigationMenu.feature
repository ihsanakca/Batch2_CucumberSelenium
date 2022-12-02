@navigate
Feature: Krafttech Dashboard test

  @Mike
  Scenario: Logged as Mike
    Given The user is on the login page
    When Take the Dashboard actual text
    And  Assert the first expected text
    And  go to Developers menu and get the text of Developer
    Then Assert the second expected text as developer

  @Sebastian
  Scenario: Logged as Sebastian
    Given The user is on the login page
    When Take the Dashboard actual text
    And  Assert the first expected text
    And  go to Edit Profile menu and get the text of Edit User Profile
    Then Assert the second expected text as edit user profile

  @JhonNash @db
  Scenario: Logged as Jhon Nash
    Given The user is on the login page
    When Take the Dashboard actual text
    And  Assert the first expected text
    And  go to My Profile menu and get the text of User Profile
    Then Assert the second expected text as edit user profile

