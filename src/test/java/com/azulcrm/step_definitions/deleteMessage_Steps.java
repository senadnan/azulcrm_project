package com.azulcrm.step_definitions;

import com.azulcrm.pages.MessageModule;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

public class deleteMessage_Steps {

    MessageModule messageModule = new MessageModule();

    @When("User searches the message that he wants to delete")
    public void user_searches_the_message_that_he_wants_to_delete() {

        messageModule.searchBox.sendKeys("Please specify at least one person." + Keys.ENTER);

    }
    @Then("User clicks the MORE button at the bottom of that message")
    public void user_clicks_the_more_button_at_the_bottom_of_that_message() {
        BrowserUtils.sleep(3);
        messageModule.moreBtn.click();

    }
    @Then("User clicks the Delete link")
    public void user_clicks_the_delete_link() {
        BrowserUtils.sleep(3);
        messageModule.delBtn.click();

    }
    @Then("User clicks the OK button on the pop up window")
    public void user_clicks_the_ok_button_on_the_pop_up_window() {
        BrowserUtils.sleep(3);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }
    @Then("User sees {string} message on the window")
    public void user_sees_message_on_the_window(String message) {

        Assert.assertEquals(message, messageModule.postDeletedMessage.getText());

    }


}
