Feature: Dashboard test
  Background:
    Given The user should be able to login page


  Scenario:User should be able to see Dashboard page

    When User should input "sgezer@gmail.com" and "12345678"
    Then User should see the dashboard options
      | Dashboard    |
      | Developers   |
      | Edit Profile |
      | Selim Gezer  |




