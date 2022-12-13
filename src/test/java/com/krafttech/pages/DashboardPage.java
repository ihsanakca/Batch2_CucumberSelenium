package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h1[.='Dashboard']")
    public WebElement dashboardPageTitle_loc;

    @FindBy(xpath = "(//span[.='</aFm>'])[1]")
    public WebElement aFMTitle_loc;

    @FindBy(xpath = "//span[@class='d-none d-md-block dropdown-toggle ps-2']")
    public WebElement userPopUp_loc;

    @FindBy(xpath = "(//span[.='My Profile'])[2]")
    public WebElement myProfile_loc;

    @FindBy(xpath = "//a[.='Home'")
    public WebElement homeLink_loc;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOut_loc;

    @FindBy(xpath = "//div[@class='copyright']")
    public WebElement copyright_loc;

    @FindBy(xpath = "//h3[.='isa akyuz']")
    public WebElement isaUser_loc;

    @FindBy(xpath = "//span[.='JavaScript']")
    public WebElement tabLocator_loc;

    @FindBy(xpath = "//span[.='Modal']")
    public WebElement moduleLocator_loc;

    @FindBy(xpath = "//a[@class='nav-link nav-profile d-flex align-items-center pe-0']")
    public WebElement getUserName_loc;

    @FindBy(css = "li.nav-item.dropdown")
    public List<WebElement> dashboardOptions_loc;

    @FindBy(xpath = "//li[.='Dashboard']")
    public WebElement homeName;


    public String dashboardPageTitle(String title) {
        String Title = dashboardPageTitle_loc.getText();
        return Title;
    }

    public String usersNames(String name) {
        String userNameLocator = "//h3[.='" + name + "']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(userNameLocator), 5);

        WebElement UserName = Driver.get().findElement(By.xpath(userNameLocator));

        String actualName = UserName.getText();

        return actualName;
    }

    public String getUserName() {
        BrowserUtils.waitForVisibility(getUserName_loc, 5);
        return getUserName_loc.getText();
    }

    public void dashboardProfileTabs(String tab) {

        String tabLocator = "//button[.='" + tab + "']";
        BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
        WebElement profileTab = Driver.get().findElement(By.xpath(tabLocator));
        profileTab.click();


    }

    public void dashboardTopProfileTabs(String tabName) {

        String tabLocator = "//nav//span[.='"+tabName+"']";
        BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
        WebElement profileTab = Driver.get().findElement(By.xpath(tabLocator));
        profileTab.click();

    }

    public String getHomeName(String name){
        String homeNameLocator="//li[.='"+name+"']";
        return Driver.get().findElement(By.xpath(homeNameLocator)).getText();
    }
}