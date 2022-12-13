package com.krafttech.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuStepDefs {


    @When("Take the Dashboard actual text")
    public void take_the_dashboard_actual_text() {
        System.out.println("get the dashboard text");
    }
    @When("Assert the first expected text")
    public void assert_the_first_expected_text() {
        System.out.println("assert actual dashboard text with expected text");

    }
    @When("go to Developers menu and get the text of Developer")
    public void go_to_developers_menu_and_get_the_text_of_developer() {
        System.out.println("navigate to developer menu and get text");
    }
    @Then("Assert the second expected text as developer")
    public void assert_the_second_expected_text_as_developer() {
        System.out.println("assert developer menu text with expected text");
    }

    @When("go to Edit Profile menu and get the text of Edit User Profile")
    public void go_to_edit_profile_menu_and_get_the_text_of_edit_user_profile() {
        System.out.println("navigate to edit profile menu and get text of user profile");
    }
    @Then("Assert the second expected text as edit user profile")
    public void assert_the_second_expected_text_as_edit_user_profile() {
        System.out.println("assert edit profile text with expected text");
    }
    @When("go to My Profile menu and get the text of User Profile")
    public void go_to_my_profile_menu_and_get_the_text_of_user_profile() {
        System.out.println("navigate to my profile menu and get text of user profile");
    }


}
