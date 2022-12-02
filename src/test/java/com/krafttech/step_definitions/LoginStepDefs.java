package com.krafttech.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {

        System.out.println("Batch 2 was here...");
        System.out.println("I open browser and navigate to krafttech web page..");

    }
    @When("The user enters Selim credentials")
    public void the_user_enters_selim_credentials() {
        System.out.println("I enter Selim email and password and click login button..");

    }
    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("I verify that i am on the dashboard..");

    }

    @When("The user enters Mike credentials")
    public void theUserEntersMikeCredentials() {
        System.out.println("I enter Mike email and password and click login button..");
    }

    @When("The user enters Jhon Nash credentials")
    public void theUserEntersJhonNashCredentials() {
        System.out.println("I enter Jhon Nash email and password and click login button..");
    }

    @When("The user enters Rosa credentials")
    public void the_user_enters_rosa_credentials() {
        System.out.println("I enter Rosa email and password and click login button..");
    }


}
