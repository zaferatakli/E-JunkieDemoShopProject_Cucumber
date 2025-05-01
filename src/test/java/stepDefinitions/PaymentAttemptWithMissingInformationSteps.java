package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DialogContent;

public class PaymentAttemptWithMissingInformationSteps {
    DialogContent dc = new DialogContent();

    @Then("The user should see the invalid messages")
    public void verifyInvalidEmailAndInvalidInvoiceNameErrorMessages() {
        Assert.assertTrue(dc.invalidMessage.isDisplayed(), "Invalid message not displayed");
    }
}
