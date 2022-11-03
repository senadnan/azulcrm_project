package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "USER_LOGIN")
    public WebElement userInput;

    @FindBy (name = "USER_PASSWORD")
    public WebElement passInput;

    @FindBy (id = "USER_REMEMBER")
    public WebElement rememberCheckbox;

    @FindBy (className = "login-btn")
    public WebElement loginBtn;

    @FindBy (className = "login-link-forgot-pass")
    public WebElement forgotPasswordLink;

    @FindBy (xpath = "//div[.=\"Incorrect login or password\"]")
    public WebElement incorrectLoginMessage;

    @FindBy (xpath = "//label[.=\"Remember me on this computer\"]")
    public WebElement rememberMeLink;


    public void login(String email, String password) {
        userInput.sendKeys(email);
        passInput.sendKeys(password);
        loginBtn.click();
    }



}
