Feature: Profile Test

  Background:
    Given The user should be able to login page

  Scenario: User should be able to edit profile
    When User should input login information
    And User should go to My Profile
    And User should navigate to "Edit Profile"
    And User should fill the information boxes
    Then User should verify the profile updated message


  Scenario: User should able to see profile options
    When User should input "user22@test.com" and "Test123456"
    Then User should see the profile options
      | Components |
      | Forms      |
      | JavaScript |
      | My Profile |


  Scenario: User should be able to add experience
    When User should input "sgezer@gmail.com" and "12345678"
    And User should go to My Profile
    And User should navigate to "Add Experience"
    And User should fill the experience info boxes
    Then User should verify that new experience "Kraft" is added to the overview page