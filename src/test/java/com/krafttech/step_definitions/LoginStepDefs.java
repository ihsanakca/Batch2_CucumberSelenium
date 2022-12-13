package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPages;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefs {
    LoginPages loginPages=new LoginPages();
    DashboardPage dasboardPage=new DashboardPage();
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
    @When("The user enters Sebastian credentials")
    public void theUserEntersSebastianCredentials() {
        System.out.println("I enter Sebastian email and password and click login button..");
    }
    @Given("The user should be able to login page")
    public void the_user_should_be_able_to_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("User should input login information")
    public void user_should_input_login_information() {
        loginPages.loginUser();
    }
    @Then("User should be on home page")
    public void user_should_be_on_home_page() {
        BrowserUtils.waitFor(3);
        String actualTitle=Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";
        Assert.assertEquals("verify that titles are same.",expectedTitle,actualTitle);
    }
    @When("User should input {string} and {string}")
    public void userShouldInputAnd(String email, String password) {
        loginPages.loginWithParameter(email,password);
    }
    @Then("User should input  following credentials")
    public void user_should_input_following_credentials(Map<String,String> userInfo) {
        loginPages.loginWithParameter(userInfo.get("email"),userInfo.get("password"));
        String actualName= dasboardPage.getUserName();
        String expectedName=userInfo.get("Name");
        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);
        Assert.assertEquals(expectedName,actualName);
    }
    @Then("The user should be able to see {string} and {string} and {string} warning message")
    public void theUserShouldBeAbleToSeeAndWarningMessage(String warningMsg1, String warningMsg2, String warningMsg) {
       if (!warningMsg1.equals("")){
           String actualWarning_1Text = loginPages.warningMessage1_loc.getText();
           Assert.assertEquals(warningMsg1,actualWarning_1Text);
       }
        if (!warningMsg2.equals("")){
            String actualWarning_2Text = loginPages.warningMessage2_loc.getText();
            Assert.assertEquals(warningMsg2,actualWarning_2Text);
        }
       if (!warningMsg.equals("")){
           String actualWarningText = loginPages.warningMessage_loc.getText();
           Assert.assertEquals(warningMsg,actualWarningText);
       }
    }
    @Then("The warning message contains {string}")
    public void the_warning_message_contains(String expectedWarningMsg) {
        String actualWarningMessageText = loginPages.getWarningMessageText(expectedWarningMsg);
        Assert.assertEquals(expectedWarningMsg,actualWarningMessageText);
    }
}
