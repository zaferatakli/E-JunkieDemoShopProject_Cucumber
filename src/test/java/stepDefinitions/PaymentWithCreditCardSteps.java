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
        dc.demoEBookAddToCart.click();
    }

    @And("hit the pay by credit card button.")
    public void hitThePayByCreditCardButton() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.yourCardIframe));
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        dc.creditCardButton.click();
    }

    @When("billing details page is displayed, click on the “I am a human” field")
    public void billingDetailsPageIsDisplayedClickOnTheIAmAHumanField() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.billingForm));
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.humanIframe));
        GWD.getDriver().switchTo().frame(dc.humanIframe);
        dc.humanField.click();
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.captchaFieldCheck));
    }

    @And("enter your payment details.")
    public void enterYourPaymentDetails() {
        GWD.getDriver().switchTo().defaultContent();
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.yourCardIframe));
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        dc.emailField.sendKeys(ConfigReader.getProperty("email"));
        dc.confirmEmailField.sendKeys(ConfigReader.getProperty("email"));
        dc.nameOnCardField.sendKeys(ConfigReader.getProperty("name"));

        GWD.getDriver().switchTo().frame(dc.cardIframe);
        dc.cardNumberField.sendKeys(ConfigReader.getProperty("validCreditCardNum"));
        dc.expDateField.sendKeys(ConfigReader.getProperty("validCardExpDate"));
        dc.cvcField.sendKeys(ConfigReader.getProperty("validCvc"));
    }

    @And("click the pay button.")
    public void clickThePayButton() {GWD.getDriver().switchTo().defaultContent();
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        dc.payButton.click();
    }

    @And("the successful completion of the transaction.")
    public void theSuccessfulCompletionOfTheTransaction() {
        GWD.getDriver().switchTo().defaultContent();
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmText));
        Assert.assertEquals(dc.confirmText.getText(), ConfigReader.getProperty("successMessage"));
    }
}