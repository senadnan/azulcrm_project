package com.azulcrm.step_definitions;

import com.azulcrm.pages.DashboardPage;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

public class logOut_Steps {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    //  The user can log out and ends up on the login page.
    @Then("User login to the application successfully")
    public void user_login_to_the_application_successfully() {
        loginPage.userInput.sendKeys(ConfigurationReader.getProperty("email2"));
        loginPage.passInput.sendKeys(ConfigurationReader.getProperty("password2"));
        loginPage.loginBtn.click();

    }

    @When("User logs out the application")
    public void user_logs_out_the_application() {
        dashboardPage.profileName.click();
        dashboardPage.logOutButton.click();
    }

    @Then("User ends up on the login page")
    public void user_ends_up_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }

    @And("Verify title is {string}")
    public void verifyTitleIs(String title) {
        BrowserUtils.verifyTitle(title);

    }
    // The user can not go to the home page again by clicking the step back button after successfully logging out.

    @When("User clicks step back button")
    public void user_clicks_step_back_button() throws InterruptedException {
        BrowserUtils.waitFor(3);
        Driver.getDriver().navigate().back();

    }

    // The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    @When("User closes the opened tab")
    public void userClosesTheOpenedTab() {
        Driver.closeDriver();
    }

    @And("User opens a new browser and goes to login page")
    public void userOpensANewBrowserAndGoesToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }

    @And("Verify title is {string} \\(user should NOT be able to go back home page)")
    public void verifyTitleIsUserShouldNOTBeAbleToGoBackHomePage(String title) {
        BrowserUtils.verifyTitle(title);
    }


    @When("User opens multiple tabs")
    public void userOpensMultipleTabs() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("window.open('https://www.google.com/')");
        BrowserUtils.waitFor(1);
        jse.executeScript("window.open('https://www.cambly.com/kids?lang=en')");
        BrowserUtils.waitFor(1);
        jse.executeScript("window.open('https://aws.amazon.com/')");
        BrowserUtils.sleep(1);
        jse.executeScript("window.open('https://cucumber.io/')");
    }

    @And("User closes the tab that application is running")
    public void userClosesTheTabThatApplicationIsRunning() {
        BrowserUtils.sleep(2);
        String sessionID = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(sessionID).close();

    }

    @And("User goes to login page on another tab")
    public void userGoesToLoginPageOnAnotherTab() {
        BrowserUtils.sleep(2);
        List<String> sessionIDs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(sessionIDs.get(1));
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("web.url"));
    }
}




