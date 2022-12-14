Feature: Account Type

  Scenario: first user
    Given The user should be able to login page
    When User should input "sgezer@gmail.com" and "12345678"
    Then The user name should be "Selim Gezer"

  @sss
  Scenario: second user
    Given The user should be able to login page
    When User should input "eddiem@kraft.com" and "eddiem12"
    Then The user name should be "Eddie Murphy"

  Scenario: third user
    Given The user should be able to login page
    When User should input "mike@gmail.com" and "mike1234"
    Then The user name should be "Harun"

  Scenario: fourth user
    Given The user should be able to login page
    When User should input "morganfreeman@kraft.com" and "mfreeman"
    Then The user name should be "Morgan Freeman"


  Scenario Outline: Different <userName> User Type
    Given The user should be able to login page
    When User should input "<userEmail>" and "<password>"
    Then The user name should be "<userName>"

    Examples:
      | userEmail               | password   | userName       |
      | sgezer@gmail.com        | 12345678   | Selim Gezer    |
      | eddiem@kraft.com        | eddiem12   | Eddie Murphy   |
      | mike@gmail.com          | mike1234   | Harun          |
      | morganfreeman@kraft.com | mfreeman   | Morgan Freeman |
      | rosa@test.com           | Test123456 | Rosa           |




