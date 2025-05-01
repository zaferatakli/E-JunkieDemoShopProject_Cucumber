package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class PaymentWithCreditCardSteps {
    DialogContent dc =new DialogContent();

    @Given("Navigate to E-Junkie")
    public void navigateToEJunkie() {
        GWD.getDriver().get(ConfigReader.getProperty("demoShopUrl"));

    }
}
