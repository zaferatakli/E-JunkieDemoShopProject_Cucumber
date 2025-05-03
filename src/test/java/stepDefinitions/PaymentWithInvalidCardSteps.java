package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class PaymentWithInvalidCardSteps {
    DialogContent dc = new DialogContent();

    @And("The user enter payment details and invalid card number.")
    public void theUserEnterPaymentDetailsAndInvalidCardNumber() {
        GWD.getDriver().switchTo().defaultContent();
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.yourCardIframe));
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        dc.mySendKeys(dc.emailField, ConfigReader.getProperty("email"));
        dc.mySendKeys(dc.confirmEmailField, ConfigReader.getProperty("email"));
        dc.mySendKeys(dc.nameOnCardField, ConfigReader.getProperty("name"));

        GWD.getDriver().switchTo().frame(dc.cardIframe);
        dc.mySendKeys(dc.cardNumberField, ConfigReader.getProperty("invalidCreditCardNum"));
        dc.mySendKeys(dc.expDateField, ConfigReader.getProperty("invalidCardExpDate"));
        dc.mySendKeys(dc.cvcField, ConfigReader.getProperty("invalidCvc"));
        GWD.getDriver().switchTo().defaultContent();
    }

    @And("The user clicks the Make Payment button")
    public void theUserClicksTheMakePaymentButton() {
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.payButton));
        dc.myClick(dc.payButton);
    }

    @Then("The user should see the message Your card number is invalid")
    public void theUserShouldSeeTheMessageYourCardNumberIsInvalid() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.invalidMessage));
        Assert.assertTrue("Message is not displayed.",dc.invalidMessage.isDisplayed());
    }
}