package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utilities.GWD;

@CucumberOptions(
        features = {"src/test/java/featureFiles/InformationVideo.feature"},
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class InformationVideoRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browserType")
    public void setUp(String browserType) {
        GWD.threadBrowserName.set(browserType);
    }
}