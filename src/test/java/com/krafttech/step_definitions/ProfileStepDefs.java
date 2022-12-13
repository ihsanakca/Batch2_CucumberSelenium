package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.ProfilePage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProfileStepDefs {

    ProfilePage profilePage = new ProfilePage();
    DashboardPage dashboardPage = new DashboardPage();
    Actions actions = new Actions(Driver.get());

    @When("User should go to My Profile")
    public void user_should_go_to_my_profile() {
        dashboardPage.myProfile_loc.click();
    }

    @When("User should navigate to {string}")
    public void user_should_navigate_to_edit_profile(String tabName) {
        profilePage.profileTabs(tabName);
    }

    @When("User should fill the information boxes")
    public void user_should_fill_the_information_boxes() {
        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Selim Gezer");
        profilePage.about.clear();
        profilePage.about.sendKeys("This is great work");
        profilePage.company.clear();
        profilePage.company.sendKeys("GHAN IT");

        BrowserUtils.waitForVisibility(profilePage.slider, 5);
        BrowserUtils.waitFor(3);
        profilePage.slider.clear();
        BrowserUtils.dragAndDropBy(profilePage.slider, 150, 0);

        Select select = new Select(profilePage.job);
        select.selectByVisibleText("SDET");

        profilePage.website.clear();
        profilePage.website.sendKeys("krrafttechnologie.com");
        profilePage.location.clear();
        profilePage.location.sendKeys("Ankara");
        profilePage.skills.clear();
        profilePage.skills.sendKeys("Postman, RestAssured, API, SQL");
        BrowserUtils.clickWithJS(profilePage.save);

    }

    @Then("User should verify the profile updated message")
    public void user_should_verify_the_profile_updated_message() {

        String actualMsg = profilePage.profileUpdate.getText();
        String expectedMsg = "Profile Updated";

        Assert.assertEquals("Both message should be same", expectedMsg, actualMsg);
    }

    @Then("User should see the profile options")
    public void user_should_see_the_profile_options(List<String> profileOptions_Sc) {
        List<String> actualOptions = BrowserUtils.getElementsText(profilePage.profileOptions);

        System.out.println("actualOptions.size() = " + actualOptions.size());

        System.out.println("actualOptions = " + actualOptions);
        System.out.println("profileOptions_Sc = " + profileOptions_Sc);

        Assert.assertEquals(profileOptions_Sc, actualOptions);
    }

    @When("User should fill the experience info boxes")
    public void user_should_fill_the_experience_info_boxes() {
        actions.click(profilePage.jobTitleExperiece)
                .sendKeys("SDET" + Keys.TAB)
                .sendKeys("Kraft" + Keys.TAB)
                .sendKeys("İstanbul" + Keys.TAB)
                .sendKeys("02.05.2021" + Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("11.02.2022" + Keys.TAB)
                .sendKeys("I worked in a Cucember base framework about Defence Industry ").perform();
        BrowserUtils.waitFor(3);
        actions.click(profilePage.addExperienceBtn).perform();

    }

    @Then("User should verify that new experience {string} is added to the overview page")
    public void user_should_verify_that_new_experience_is_added_to_the_overview_page(String newExperinceCompany) {
        String actualExperienceCompanyText = profilePage.getNewExperinceJobTitle(newExperinceCompany);
        String expectedExperienceCompanyText = newExperinceCompany;

        System.out.println("actualExperienceCompanyText = " + actualExperienceCompanyText);
        System.out.println("expectedExperienceCompanyText = " + expectedExperienceCompanyText);

        Assert.assertEquals("New Company should able to be seen on overview page",
                expectedExperienceCompanyText, actualExperienceCompanyText);
    }


}
