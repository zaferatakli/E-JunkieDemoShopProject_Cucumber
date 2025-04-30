package hooks;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.GWD;

public class Hooks {
    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = ((TakesScreenshot) GWD.getDriver());
                byte[] stateInMemory = ts.getScreenshotAs(OutputType.BYTES);
                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
                scenario.attach(stateInMemory, "image/png", "failure_" + scenarioName);
            } catch (Exception e) {
                System.out.println("No screenshots were taken: " + e.getMessage());
            }
        }
        GWD.quitDriver();
    }
}