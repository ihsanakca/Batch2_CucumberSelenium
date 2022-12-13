package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class DashboardStepDefs {

    DashboardPage dashboardPage=new DashboardPage();
    @Then("User should see the dashboard options")
    public void user_should_see_the_dashboard_options(List<String> dashBoardOptions_Sc) {

        List<String> actualDashboardOptionsText=BrowserUtils.getElementsText(dashboardPage.dashboardOptions_loc);

        System.out.println("actualDashboardOptionsText = " + actualDashboardOptionsText);
        System.out.println("dashBoardOptions_Sc = " + dashBoardOptions_Sc);

        Assert.assertEquals("verify that options are same",dashBoardOptions_Sc,actualDashboardOptionsText);

    }

    @Then("The user name should be {string}")
    public void the_user_name_should_be(String expectedName) {
        String actualName = dashboardPage.getUserName();
        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);

        Assert.assertEquals("Verify that names are mathc",expectedName,actualName);
    }

}
