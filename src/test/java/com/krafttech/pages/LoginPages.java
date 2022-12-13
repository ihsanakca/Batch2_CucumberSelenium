package com.krafttech.pages;

import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages extends BasePage{

    public LoginPages(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "email")
    public WebElement userEmailInput_loc;

    @FindBy(name = "password")
    public WebElement passwordInput_loc;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement submitButton_loc;

    @FindBy(xpath ="//*[contains(text(),'Email address or pass')]" )
    public WebElement warningMessage_loc;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement warningMessage1_loc;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement warningMessage2_loc;


    public void loginUser(){
        String username= ConfigurationReader.get("userEmail");
        String password= ConfigurationReader.get("password");

        userEmailInput_loc.sendKeys(username);
        passwordInput_loc.sendKeys(password);
        submitButton_loc.click();
    }
    public void loginWithParameter(String email, String password){

        userEmailInput_loc.sendKeys(email);
        passwordInput_loc.sendKeys(password);
        submitButton_loc.click();
    }

    public String getWarningMessageText(String message){
        return Driver.get().findElement(By.xpath("//*[contains(text(),'"+message+"')]")).getText();
    }

}
