package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigateMenuWithParameterStepDefs {
DashboardPage dashboardPage=new DashboardPage();
    @When("The user navigates to {string} menu")
    public void the_user_navigates_to_menu(String profileTab) {
        dashboardPage.dashboardTopProfileTabs(profileTab);
    }
    @Then("The user should be able to see home name as {string}")
    public void the_user_should_be_able_to_see_home_name_as(String homeName) {
        String actualHomeName = dashboardPage.getHomeName(homeName);
        System.out.println("actualHomeName = " + actualHomeName);
        System.out.println("homeName = " + homeName);

        Assert.assertEquals("Home pages name should be same",homeName,actualHomeName);
    }
}
