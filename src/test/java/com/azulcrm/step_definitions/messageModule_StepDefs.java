package com.azulcrm.step_definitions;

import com.azulcrm.pages.MessageModule;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class messageModule_StepDefs {

    MessageModule messageModule = new MessageModule();


    // User should be able to send a message by filling in the mandatory fields.
    @When("User clicks MESSAGE module")
    public void user_clicks_message_module() {
        messageModule.messageBtn.click();
    }


    @When("User writes a message {string} and {string} into Message box")
    public void user_writes_a_message_and_into_message_box(String messageTitle, String messageText) {

        messageTitle = ConfigurationReader.getProperty("messageTitle");
        messageText = ConfigurationReader.getProperty("messageText");

        messageModule.postTitle.sendKeys(messageTitle);
        BrowserUtils.waitFor(1);
        Driver.getDriver().switchTo().frame(messageModule.messageIframe);
        messageModule.messageBody.sendKeys(messageText);
        Driver.getDriver().switchTo().parentFrame();

    }

    @Then("User should see the created Message Title and Message Body on the Activity Stream")
    public void user_should_see_the_created_message_title_and_message_body_on_the_active_stream() {

        String expectedMessageTitle = ConfigurationReader.getProperty("messageTitle");
        String actualMessageTitle = messageModule.createdMessageTitle.getText();
        String expectedMessage = ConfigurationReader.getProperty("messageText");
        String actualMessage = messageModule.createdMessage.getText();

        System.out.println("expectedMessageTitle = " + expectedMessageTitle);
        System.out.println("actualMessageTitle = " + actualMessageTitle);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertEquals(expectedMessageTitle, actualMessageTitle);

    }


    @Then("User clicks SEND button")
    public void user_clicks_send_button() {
        // BrowserUtils.waitForClickablility(messageModule.sendBtn, 2);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", messageModule.sendBtn);
        BrowserUtils.sleep(2);

    }

    @Then("All Employees button should be seen as default recipient")
    public void allEmployeesButtonShouldBeSeenAsDefaultRecipient() {
        BrowserUtils.waitForVisibility(messageModule.allEmployeesBtn, 2);
        Assert.assertTrue(messageModule.allEmployeesBtn.isDisplayed());
        System.out.println("All employees buttons.isDisplayed() = " + messageModule.allEmployeesBtn.isDisplayed());
    }

    @And("User removes default recipient")
    public void userRemovesDefaultRecipient() {
        BrowserUtils.sleep(2);
        messageModule.removeAllEmp.click();
    }

    @Then("User clicks {string} link")
    public void user_clicks_link(String addPersons) {
        messageModule.addRecipients.click();
        BrowserUtils.waitFor(1);

    }

    @Then("User clicks {string} link on the opened window")
    public void user_clicks_link_on_the_opened_window(String empAndDept) {
        messageModule.employeesAndDepartmentsTab.click();
        BrowserUtils.waitFor(1);
    }

    @And("User clicks a person {string} from the people list")
    public void userClicksAPersonFromThePeopleList(String person) {
        person = messageModule.email2;

        for (WebElement eachPerson : messageModule.employeesAndDepartments) {
            System.out.println("eachPerson.getText() = " + eachPerson.getText());
            if (eachPerson.getText().equals(person)) {
                eachPerson.click();
            }
        }
        BrowserUtils.sleep(1);
    }


    @Then("User adds a {string} from the department list")
    public void user_adds_a_from_the_department_list(String department) {

        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("window.scrollBy(0,400)");
        department = messageModule.department1;

        for (WebElement eachDepartment : messageModule.departments) {
            System.out.println("eachDepartment.getText() = " + eachDepartment.getText());
            if (eachDepartment.getText().equals(department)) {
                eachDepartment.click();
            }
        }
        BrowserUtils.sleep(2);

        messageModule.salesForceSubDep.click();
    }

    @When("User should be able to search the recipients")
    public void user_should_be_able_to_search_the_recipients() {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", messageModule.searchRecipientInput);
        BrowserUtils.waitFor(1);
        messageModule.searchRecipientInput.sendKeys("arben" + Keys.ENTER);
        BrowserUtils.waitFor(1);
        messageModule.searchRecipientInput.sendKeys("asiya" + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @When("User enters a {string}")
    public void user_enters_a(String messageTitle) {
        messageTitle = ConfigurationReader.getProperty("messageTitle");
        messageModule.postTitle.sendKeys(messageTitle);
        BrowserUtils.waitFor(1);
    }


    @When("User does NOT write a Message Text")
    public void user_does_not_write_a_message_text() {

    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String messageTextEmptyError) {
        BrowserUtils.waitForVisibility(messageModule.messageTextError, 2);
        String actualMessageTextError = messageModule.messageTextError.getText();
        Assert.assertEquals(messageTextEmptyError, actualMessageTextError);
    }

    @When("User does NOT write a {string}")
    public void user_does_not_write_a(String messageTopic) {
        // User leaves message Topic and message Text fields BLANK
        BrowserUtils.waitFor(1);
    }

    @When("User does NOT write a Message Topic")
    public void user_does_not_write_a_message_topic() {
        // User leaves message Topic field BLANK
        BrowserUtils.waitFor(1);
    }

    @Then("User should see {string} message")
    public void user_should_see_message(String messageTitleError) {
        BrowserUtils.waitFor(2);
        String actualMessageTitleError = messageModule.messageTitleError.getText();
        Assert.assertEquals(messageTitleError, actualMessageTitleError);
    }


    @Then("User should be able to see  {string} message")
    public void user_should_be_able_to_see_message(String noRecipientError) {
        BrowserUtils.waitForVisibility(messageModule.noRecipientError, 2);
        String actualErrorMessage = messageModule.noRecipientError.getText();
        Assert.assertEquals(noRecipientError, actualErrorMessage);
    }

    @Then("User CANCELS sending this message")
    public void user_cancels_sending_this_message() {
        BrowserUtils.sleep(2);
        messageModule.cancelBtn.click();
    }

    @When("User searches the message that he wants to delete")
    public void user_searches_the_message_that_he_wants_to_delete() {

        messageModule.searchBox.sendKeys("jira test" + Keys.ENTER);
        BrowserUtils.waitFor(1);
    }


    @Then("User clicks the MORE button at the bottom of that message")
    public void user_clicks_the_more_button_at_the_bottom_of_that_message() {
        BrowserUtils.sleep(2);
        messageModule.moreBtn.click();

    }
    @Then("User clicks the Delete link")
    public void user_clicks_the_delete_link() {
        BrowserUtils.sleep(2);
        messageModule.delBtn.click();

    }
    @Then("User clicks the OK button on the pop up window")
    public void user_clicks_the_ok_button_on_the_pop_up_window() {
        BrowserUtils.sleep(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }
    @Then("User sees {string} message on the window")
    public void user_sees_message_on_the_window(String message) {
        BrowserUtils.sleep(2);
        System.out.println("Message: " + messageModule.postDeletedMessage.getText());
        Assert.assertEquals(message, messageModule.postDeletedMessage.getText());

    }



}
