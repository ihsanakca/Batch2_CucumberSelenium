package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage{


    @FindBy(xpath = "//button[.='Edit Profile'] ")
    public WebElement editBtn;

    @FindBy(css = "#name")
    public WebElement fullName;

    @FindBy(css = "#about")
    public WebElement about;

    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement company;

    @FindBy(css = "#terms")
    public WebElement slider;

    @FindBy(css = ".form-select")
    public WebElement job;

    @FindBy(xpath = "//input[@id='website']")
    public WebElement website;

    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement location;

    @FindBy(xpath = "//input[@id='skills']")
    public WebElement skills;

    @FindBy(xpath = "//button[.='Save Changes']")
    public WebElement save;

    @FindBy(xpath = "//input[@placeholder='Job Title *']")
    public WebElement jobTitleExperiece;

    @FindBy(xpath = " //input[@placeholder='Company *']")
    public WebElement companyExperience;

    @FindBy(xpath = "//input[@placeholder='Location'] ")
    public WebElement locationExperience;

    @FindBy(xpath = "(//input[@placeholder='From Date'])[1]")
    public WebElement startYearExperience;

    @FindBy(xpath = "(//input[@placeholder='To Date '])[1]")
    public WebElement endYearExperience;

    @FindBy(xpath = "//textarea[@placeholder='Job Description']")
    public WebElement jobDescriptionExperience;

    @FindBy(xpath = "//button[@value='experience']")
    public WebElement addExperienceBtn;

    @FindBy (xpath = "//div[@class='alert alert-success bg-success text-light border-0 alert-dismissible fade show']")
    public WebElement profileUpdate;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement profileEmail_loc;

    @FindBy(xpath = "//a[@class='nav-link collapsed']")
    public List<WebElement> profileOptions;

    @FindBy(xpath = "//td[.='ddd']")
    public WebElement newExperinceTitle_loc;




    public void profileTabs(String tab){

        String tabLocator="//button[.='"+tab+"']";
        BrowserUtils.waitForClickablility(By.xpath(tabLocator),5);
        WebElement profileTab= Driver.get().findElement(By.xpath(tabLocator));
        profileTab.click();

    }

    public String getNewExperinceJobTitle(String company){
        String titleLoc="//td[.='"+company+"']";
        WebElement newExperinceJobTitleElement=Driver.get().findElement(By.xpath(titleLoc));
        return newExperinceJobTitleElement.getText();
    }

}
