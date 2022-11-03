package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "[id=\"user-name\"]")
    public WebElement profileName;

    @FindBy(xpath = "div[id=\"user-block\"]")
    public WebElement userBlock;

    @FindBy(linkText = "Log out")
    public WebElement logOutButton;




}
