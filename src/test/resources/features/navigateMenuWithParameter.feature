Feature: Navigate to menu with parameter


  Scenario: Selim navigates to edit profile
    Given The user should be able to login page
    When User should input "sgezer@gmail.com" and "12345678"
    Then The user name should be "Selim Gezer"
    When The user navigates to "Edit Profile" menu
    Then The user should be able to see home name as "Edit User Profile"


  Scenario: Eddie Murphy navigates to edit profile
    Given The user should be able to login page
    When User should input "eddiem@kraft.com" and "eddiem12"
    Then The user name should be "Eddie Murphy"
    When The user navigates to "Developers" menu
    Then The user should be able to see home name as "Developers"

  @rerun
  Scenario: Morgan Freeman navigates to edit profile
    Given The user should be able to login page
    When User should input "morganfreeman@kraft.com" and "mfreeman"
    Then The user name should be "Morgan Freeman"
    When The user navigates to "Dashboard" menu
    Then The user should be able to see home name as "Dashboard"



  Scenario Outline: <userName> navigates to <profileTabName> menu
    Given The user should be able to login page
    When User should input "<userEmail>" and "<password>"
    Then The user name should be "<userName>"
    When The user navigates to "<profileTabName>" menu
    Then The user should be able to see home name as "<homeName>"

    Examples:
      | userEmail               | password | userName       | profileTabName | homeName          |
      | sgezer@gmail.com        | 12345678 | Selim Gezer    | Edit Profile   | Edit User Profile |
      | eddiem@kraft.com        | eddiem12 | Eddie Murphy   | Developers     | Developers        |
      | morganfreeman@kraft.com | mfreeman | Morgan Freeman | Dashboard      | Dashboard         |