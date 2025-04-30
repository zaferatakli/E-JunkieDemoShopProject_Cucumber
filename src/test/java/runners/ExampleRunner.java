package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utilities.ExtentReportManager;
import utilities.GWD;

@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class ExampleRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browserType")
    public void setUp(String browserType) {
        GWD.threadBrowserName.set(browserType);
        ExtentReportManager.setBrowserName(browserType);
    }

    @AfterClass
    public static void writeExtendReport() {
        ExtentReportManager.writeMetadata();
    }
}