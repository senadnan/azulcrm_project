package com.azulcrm.step_definitions;

import com.azulcrm.pages.MessageModule;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class messageModule_StepDefs {

    MessageModule messageModule = new MessageModule();


    // User should be able to send a message by filling in the mandatory fields.
    @When("User clicks MESSAGE module")
    public void user_clicks_message_module() {
        messageModule.messageBtn.click();
    }


    @When("User writes a message {string} into Message box")
    public void userWritesAMessageIntoMessageBox(String messageText) {
        messageText = ConfigurationReader.getProperty("messageText");
        Driver.getDriver().switchTo().frame(messageModule.messageIframe);
        messageModule.messageBody.sendKeys(messageText);
        Driver.getDriver().switchTo().parentFrame();
    }

    @And("User should see the created Message on the Active Stream")
    public void userShouldSeeTheCreatedMessageOnTheActiveStream() {

        String expectedMessage = ConfigurationReader.getProperty("messageText");
        String actualMessage = messageModule.createdMessage.getText();

        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User clicks SEND button")
    public void user_clicks_send_button() {
        BrowserUtils.waitForClickablility(messageModule.sendBtn, 5);
        messageModule.sendBtn.click();
        BrowserUtils.sleep(3);

    }

    // The message delivery should be to 'All employees' by default and should be changeable.
    @Then("All Employees button should be seen as default recipient")
    public void allEmployeesButtonShouldBeSeenAsDefaultRecipient() {
        BrowserUtils.waitForVisibility(messageModule.allEmployeesBtn, 3);
        Assert.assertTrue(messageModule.allEmployeesBtn.isDisplayed());
        System.out.println("All employees buttons.isDisplayed() = " + messageModule.allEmployeesBtn.isDisplayed());
    }

    @And("User should be able to change the recipients")
    public void userShouldBeAbleToChangeTheRecipients() {
        messageModule.removeAllEmp.click();
        BrowserUtils.sleep(2);
        messageModule.addRecipients.click();
        BrowserUtils.sleep(2);
        messageModule.empDepBtn.click();
        BrowserUtils.sleep(2);
        messageModule.qaDepBtn.click();
        BrowserUtils.sleep(2);
        messageModule.qaSubDepBtn.click();
        BrowserUtils.sleep(2);

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", messageModule.sendBtn);


    }

    @And("User is be able to search recipient in the Message Module")
    public void userIsBeAbleToSearchRecipientInTheMessageModule() {
        BrowserUtils.sleep(2);
        messageModule.searchRecipientInput.sendKeys("Devs");
    }

    @And("User chooses a persons {string}")
    public void userChoosesAPersons(String person) {
        person=messageModule.email1;

        for (WebElement each :messageModule.recentPerson ) {
            if (each.getText().equals(person)){
                each.click();
            }
        }

        BrowserUtils.sleep(1);

    }
    @And("user clicks the Employees and departments tab")
    public void userClicksTheEmployeesAndDepartmentsTab() {
        messageModule.employeesAndDepartmentsTab.click();
        BrowserUtils.sleep(1);
    }
    @And("user clicks a person {string} from the people list")
    public void userClicksAPersonFromThePeopleList(String person) {
        person = messageModule.email2;

        for (WebElement each : messageModule.employeesAndDepartments) {

            if(each.getText().equals(person)){
                each.click();
            }
        }
        BrowserUtils.sleep(1);
    }

    @When("User writes message into Message box")
    public void userWritesMessageIntoMessageBox() {
    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String errorMessage1) {
        String actualErrorMessage = messageModule.messageTitleError.getText();
        Assert.assertEquals(errorMessage1, actualErrorMessage);
    }

    @And("User removes default recipient")
    public void userRemovesDefaultRecipient() {
        BrowserUtils.sleep(2);
        messageModule.removeAllEmp.click();
    }

    @Then("An {string} message should be displayed")
    public void anMessageShouldBeDisplayed(String errorMessage2) {
        String actualErrorMessage = messageModule.noRecipientError.getText();
        Assert.assertEquals(errorMessage2, actualErrorMessage);
    }

    @And("User add some recipients for this message")
    public void userAddSomeRecipientsForThisMessage() {

        messageModule.addRecipients.click();
        messageModule.inputAddRecipient.sendKeys("Cate Nimal");
        BrowserUtils.sleep(2);

    }

    @Then("User cancels sending this message")
    public void userCancelsSendingThisMessage() {
        BrowserUtils.sleep(2);
        messageModule.cancelBtn.click();
    }





}
