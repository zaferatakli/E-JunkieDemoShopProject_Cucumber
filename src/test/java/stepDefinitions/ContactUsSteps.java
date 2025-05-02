package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;

public class ContactUsSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to E-Junkie homepage")
    public void navigateToEJunkieHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("demoShopUrl"));
        String expectedUrl = ConfigReader.getProperty("demoShopUrl");
        String actualUrl = GWD.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL is not correct");
    }

    @When("The user clicks the Contact Us button")
    public void theUserClicksTheContactUsButton() {
        dc.myClick(dc.contactUsButton);
    }

    @And("The user fills in the contact form with valid details")
    public void theUserFillsInTheContactFormWithValidDetails() {
        GWD.getWait().until(ExpectedConditions.urlToBe(ConfigReader.getProperty("contactUsUrl")));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), ConfigReader.getProperty("contactUsUrl"), "URL is not correct");
        dc.mySendKeys(dc.nameField, ConfigReader.getProperty("name"));
        dc.mySendKeys(dc.emailFieldContactUs, ConfigReader.getProperty("email"));
        dc.mySendKeys(dc.subjectField, ConfigReader.getProperty("subject"));
        dc.mySendKeys(dc.messageField, ConfigReader.getProperty("message"));
    }

    @And("The user clicks the Send Message button without verifying captcha")
    public void theUserClicksTheButtonWithoutVerifyingCaptcha() {
        dc.myClick(dc.sendMessageButton);
    }

    @Then("A Recaptcha didn't match alert should be displayed")
    public void aAlertShouldBeDisplayed() {
        GWD.getWait().until(ExpectedConditions.alertIsPresent());
        String alertText = GWD.getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertText, ConfigReader.getProperty("captchaAlert"), "Alert text is not correct");
        GWD.getDriver().switchTo().alert().accept();
    }

    @And("The user completes the captcha verification")
    public void theUserCompletesTheCaptchaVerification() {
        GWD.getDriver().switchTo().frame(dc.recaptchaIframe);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.recaptchaCheckbox));
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.recaptchaCheckbox));
        dc.myClick(dc.recaptchaCheckbox);
        ReusableMethods.waitForManualCaptchaSolution(dc.recaptchaCheckboxTick);
        GWD.getDriver().switchTo().defaultContent();
    }

    @And("The user clicks the Send Message button")
    public void theUserClicksTheSendMessageButton() {
        dc.myClick(dc.sendMessageButton);
    }

    @Then("A Your message has been sent successfully message should be displayed")
    public void aMessageShouldBeDisplayed() {
        /// When the send message button is pressed after filling out the contact us form on the site,
        ///the 'Message sent successfully' tool should appear, while the 'Recaptcha didn't match' alert appears on the screen on the site.
        ///and the test fails. screenshot of this error screenshot was taken.
        ///and testReports/screenshots/ContactUsPositiveScenarioBugScreenshot.png has been added to this address.
        GWD.getWait().until(ExpectedConditions.alertIsPresent());
        String successMessageText = GWD.getDriver().switchTo().alert().getText();
        Assert.assertEquals(successMessageText, ConfigReader.getProperty("contactUsSuccessMessage"), "Success Message text is not correct");
        GWD.getDriver().switchTo().alert().accept();
    }
}