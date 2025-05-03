package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class PaymentWithCreditCardSteps {
    DialogContent dc = new DialogContent();

    @And("click AddToCart for Demo eBook.")
    public void clickAddToCartForDemoEBook() {
        dc.myClick(dc.demoEBookAddToCart);
    }

    @And("hit the pay by credit card button.")
    public void hitThePayByCreditCardButton() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.yourCardIframe));
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        dc.myClick(dc.creditCardButton);
    }

    @When("billing details page is displayed, click on the “I am a human” field")
    public void billingDetailsPageIsDisplayedClickOnTheIAmAHumanField() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.billingForm));
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.humanIframe));
        GWD.getDriver().switchTo().frame(dc.humanIframe);
        dc.myClick(dc.humanField);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.captchaFieldCheck));
    }

    @And("enter your payment details.")
    public void enterYourPaymentDetails() {
        GWD.getDriver().switchTo().defaultContent();
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.yourCardIframe));
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        dc.mySendKeys(dc.emailField, ConfigReader.getProperty("email"));
        dc.mySendKeys(dc.confirmEmailField, ConfigReader.getProperty("email"));
        dc.mySendKeys(dc.nameOnCardField, ConfigReader.getProperty("name"));

        GWD.getDriver().switchTo().frame(dc.cardIframe);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.cardNumberField));
        dc.mySendKeys(dc.cardNumberField, ConfigReader.getProperty("validCreditCardNum"));
        dc.mySendKeys(dc.expDateField, ConfigReader.getProperty("validCardExpDate"));
        dc.mySendKeys(dc.cvcField, ConfigReader.getProperty("validCvc"));
    }

    @And("click the pay button.")
    public void clickThePayButton() {GWD.getDriver().switchTo().defaultContent();
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.payButton));
        dc.myClick(dc.payButton);
    }

    @And("the successful completion of the transaction.")
    public void theSuccessfulCompletionOfTheTransaction() {
        GWD.getDriver().switchTo().defaultContent();
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmText));
        Assert.assertEquals(dc.confirmText.getText(), ConfigReader.getProperty("successMessage"));
    }
}