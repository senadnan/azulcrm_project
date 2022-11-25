package com.azulcrm.pages;

import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessageModule {

    public MessageModule() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@id=\"feed-add-post-form-tab-message\"]")
    public WebElement messageBtn;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendBtn;

    @FindBy(xpath ="//button[@id='blog-submit-button-cancel']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//span[@class=\"feed-add-post-destination-text\"]")
    public WebElement allEmployeesBtn;

    @FindBy(xpath = "//a[@class=\"feed-add-destination-link\"]")
    public WebElement addMoreLink;

    @FindBy(xpath = "//iframe[@class=\"bx-editor-iframe\"]")
    public WebElement messageIframe;

    @FindBy(css = "span[title=\"Topic\"]")
    public WebElement topicBtn;

    @FindBy(xpath = "//input[@id='POST_TITLE']")
    public WebElement postTitle;

    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[2]/div/div[3]/div[2]/div[1]/div/div[1]/div[3]/div[1]/div")
    public WebElement createdMessage;

    @FindBy(linkText = ("Wooden Spoon"))
    public WebElement createdMessageTitle;

    @FindBy(css = "body[style=\"min-height: 184px;\"]")
    public WebElement messageBody;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement removeAllEmp;

    @FindBy(xpath = "//*[@id='bx-destination-tag']")
    public WebElement addRecipients;

    @FindBy(xpath = "//*[@class='bx-finder-company-department-text']")
    public List<WebElement> departments;

    public String email1 = "helpdesk38@cybertekschool.com";
    public String email2 = "hr77@cybertekschool.com";
    public String email3 = "helpdesk24@cybertekschool.com";
    public String department1 = "Salesforce Department";

    @FindBy(linkText = "Employees and departments")
    public WebElement employeesAndDepartmentsTab;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name']")
    public List<WebElement> employeesAndDepartments;

    @FindBy(xpath = "//*[.='Salesforce Department']")
    public WebElement salesForceDep;

    @FindBy(xpath = "//*[@rel='Salesforce Department: All department and subdepartment employees']")
    public WebElement salesForceSubDep;

    @FindBy(xpath = "//*[@id='feed-add-post-destination-input']")
    public WebElement searchRecipientInput;

    @FindBy(xpath = "//span[.='The message title is not specified']")
    public WebElement messageTitleError;

    @FindBy(xpath = "//span[.='Please specify at least one person.']")
    public WebElement noRecipientError;


    @FindBy(xpath = "//span[.='The message text is empty.']")
    public WebElement messageTextError;


    @FindBy(css = "input[id=\"LIVEFEED_search\"]")
    public WebElement searchBox;



    @FindBy(css = "span[id='feed-post-more-2786']")
    public WebElement moreBtn;



    @FindBy(xpath = "(//span[@class='menu-popup-item-text'])[7]")
    // span[contains(text(),'Delete')]
    public WebElement delBtn;

    @FindBy(xpath = "//span[contains(text(),'The post has been deleted.')]")
    public WebElement postDeletedMessage;

    @FindBy(xpath = "//div[contains(text(),'Searching')]")
    public WebElement searchResultWindow;


}
