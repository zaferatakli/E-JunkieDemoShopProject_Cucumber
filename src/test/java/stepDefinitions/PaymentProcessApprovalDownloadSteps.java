package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class PaymentProcessApprovalDownloadSteps {
    DialogContent dc = new DialogContent();

    @And("memorize the “Demo eBook” price.")
    public void memorizeTheDemoEBookPrice() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.eBookPrice));
        String expectedBookPrice = dc.eBookPrice.getText().replaceAll("[^0-9.,]", "");
        ConfigReader.saveToConfig("expectedBookPrice",expectedBookPrice);
    }

    @And("download the book by checking the price.")
    public void downloadTheBookByCheckingThePrice() {
        String eBookPrice = dc.lastEBookPrice.getText().replaceAll("[^0-9.,]", "");
        Assert.assertEquals(eBookPrice, ConfigReader.getProperty("expectedBookPrice"), "The first price and the last price are different.");
        dc.downloadBtn.click();
    }
}