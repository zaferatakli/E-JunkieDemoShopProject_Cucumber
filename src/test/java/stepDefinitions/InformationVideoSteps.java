package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.*;

public class InformationVideoSteps {
    DialogContent dc = new DialogContent();

    @When("The user clicks the E-commerce by E-junkie button")
    public void theUserClicksTheECommerceByEJunkieButton() {
        dc.myClick(dc.eCommerceByEJunkieLink);
    }

    @And("The user clicks the see how is works button")
    public void theUserClicksTheSeeHowIsWorksButton() {
        GWD.getDriver().navigate().refresh();
        dc.myClick(dc.howItWorksButton);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.playButton));
        Assert.assertTrue(dc.playButton.isDisplayed(), "Play button is not displayed");
    }

    @And("The user clicks the play button")
    public void theUserClicksThePlayButton() {
        dc.myClick(dc.playButton);
        MyFunc.sleep(11);// Sleep for 11 seconds to allow the video to play
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.closeButton));// Sleep for 11 seconds to allow the video to play
        Assert.assertTrue(dc.closeButton.isDisplayed(), "Close button is not displayed");
    }

    @Then("The user clicks the close button")
    public void theUserClicksTheCloseButton() {
        dc.myClick(dc.closeButton);
    }
}