package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class AccessToEJunkieHomePageSteps {
    DialogContent dc = new DialogContent();

    @When("The user clicks the E-Commerce by E-Junkie link")
    public void theUserClicksTheECommerceByEJunkieLink() {
        dc.myClick(dc.eCommerceByEJunkieLink);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.eJunkieLogo));
        Assert.assertTrue(dc.eJunkieLogo.isDisplayed(), "E-Junkie logo is not displayed");
    }

    @Then("The user should be redirected to the E-Junkie copy page")
    public void theUserShouldBeRedirectedToTheEJunkieCopyPage() {
        Assert.assertTrue(dc.eJunkieLogo.isDisplayed(), "E-Junkie logo is not displayed");
    }

    @And("The user clicks the E-Junkie logo")
    public void theUserClicksTheEJunkieLogo() {
        dc.myClick(dc.eJunkieLogo);
    }

    @Then("The user should be redirected to the E-Junkie homepage")
    public void theUserShouldBeRedirectedToTheEJunkieHomepage() {
        GWD.getWait().until(ExpectedConditions.urlToBe(ConfigReader.getProperty("eJunkieUrl")));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), ConfigReader.getProperty("eJunkieUrl"), "URL is not correct");
    }
}