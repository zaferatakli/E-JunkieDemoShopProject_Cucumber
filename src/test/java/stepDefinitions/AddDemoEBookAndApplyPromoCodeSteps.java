package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class AddDemoEBookAndApplyPromoCodeSteps {
    DialogContent dc = new DialogContent();

    @When("The user clicks the Add Promo Code button")
    public void theUserClicksTheAddPromoCodeButton() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.yourCardIframe));
        GWD.getDriver().switchTo().frame(dc.yourCardIframe);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.addPromoCodeButton));
        dc.myClick(dc.addPromoCodeButton);
    }

    @And("The user enters an invalid promo code")
    public void theUserEntersAnInvalidPromoCode() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.promoCodeField));
        dc.promoCodeField.sendKeys(ConfigReader.getProperty("promoCode")+ Keys.ENTER);
    }

    @Then("The user should see an Invalid promotional code warning message")
    public void theUserShouldSeeAnInvalidPromotionalCodeWarningMessage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.invalidMessage));
        Assert.assertTrue("Message not be displayed.", dc.invalidMessage.isDisplayed());
    }
}