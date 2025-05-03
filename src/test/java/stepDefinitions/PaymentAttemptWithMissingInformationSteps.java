package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

public class PaymentAttemptWithMissingInformationSteps {
    DialogContent dc = new DialogContent();

    @Then("The user should see the invalid messages")
    public void verifyInvalidEmailAndInvalidInvoiceNameErrorMessages() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.payButton));
        dc.myClick(dc.payButton);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.invalidMessage));
        Assert.assertTrue(dc.invalidMessage.isDisplayed(), "Invalid message not displayed");
    }
}