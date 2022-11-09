package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.GetPasswordPage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_Steps {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    GetPasswordPage getPasswordPage = new GetPasswordPage();

    @Given("User goes to the login page")
    public void user_goes_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }

    // TESTING WITH VALID CREDENTIALS
    @When("User enters valid email {string} in to the login input box")
    public void user_enters_valid_email_in_to_the_login_input_box(String email) {
        loginPage.userInput.sendKeys(email);
    }

    @When("User enter valid password {string} in to the password input box")
    public void user_enter_valid_password_in_to_the_password_input_box(String password) {
        loginPage.passInput.sendKeys(password);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginBtn.click();
    }

    @Then("User login to the application successfully and verify URL contains {string}")
    public void userLoginToTheApplicationSuccessfullyAndVerifyURLContains(String url) {
        BrowserUtils.verifyURLContains(url);
    }



    // TESTING WITH INVALID CREDENTIALS

    @When("User enters invalid email {string} and invalid password {string}")
    public void user_enters_invalid_email_and_invalid_password(String email, String password) {
        loginPage.login(email, password);

    }

    @When("User enters invalid email {string} and valid password {string}")
    public void user_enters_invalid_email_and_valid_password(String email, String password) {
        loginPage.login(email, password);
    }

    @When("User enters valid email {string} and invalid password {string}")
    public void user_enters_valid_email_and_invalid_password(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("User should see {string} message")
    public void user_should_see_message(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.incorrectLoginMessage.getText());
    }

    // TESTING WITH BLANK CREDENTIALS

    @When("User enters email {string}")
    public void user_enters_email(String email) {
        loginPage.userInput.sendKeys(email);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        loginPage.userInput.sendKeys(password);
    }

    //FORGOT PASSWORD LINK VERIFICATION

    @When("User Clicks {string} link")
    public void userClicksLink(String link) {
        BrowserUtils.sleep(2);
        loginPage.forgotPasswordLink.click();

    }

    @Then("User should lands on the {string} page")
    public void userShouldLandsOnThePage(String getPasswordText) {
        BrowserUtils.sleep(2);
        Assert.assertTrue(getPasswordPage.getPasswordText.isDisplayed());

        System.out.println("web element isDisplayed = " + getPasswordPage.getPasswordText.isDisplayed());

    }

    // REMEMBER ME CHECKBOX AND TEXT VERIFICATION

    @When("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }

    @Then("User should see {string} link exists and is clickable")
    public void userShouldSeeLinkExistsAndIsClickable(String rememberMeText) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.rememberCheckbox));
        loginPage.rememberCheckbox.click();
        Assert.assertEquals(rememberMeText, loginPage.rememberMeLink.getText());
        Assert.assertTrue(loginPage.rememberCheckbox.isEnabled());

    }

    // BULLET SIGNS VERIFICATION

    @When("User enters password {string} into the password input box")
    public void user_enters_password_into_the_password_input_box(String password) {
        loginPage.passInput.sendKeys(password);
    }

    @Then("User should see password in bullet signs by default")
    public void user_should_see_password_in_bullet_signs_by_default() {
        String expectedAttributeValue = "password";
        Assert.assertEquals(expectedAttributeValue, loginPage.passInput.getAttribute("type"));
    }

    //ENTER KEY VERIFICATION

    @When("User hits the ENTER key of the keyboard to login the application")
    public void user_hits_the_enter_key_of_the_keyboard_to_login_the_application() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.loginBtn.sendKeys("" + Keys.ENTER);

    }

    @Then("Enter key is should be worked")
    public void enter_key_is_should_be_worked() {
    }

    // PROFILE NAME VERIFICATION
    @Then("User should see his own profileName {string} in the profile menu, after successful login")
    public void user_should_see_his_her_own_username_in_the_profile_menu_after_successful_login(String profileName) {
        Assert.assertEquals(profileName, dashboardPage.profileName.getText());
    }



}
