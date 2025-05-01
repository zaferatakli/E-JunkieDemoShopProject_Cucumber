package hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ExtentReportManager;
import utilities.GWD;

public class Hooks {
    @Before
    public void before(Scenario scenario) {
        ExtentTest test = ExtentService.getInstance().createTest(scenario.getName());
        ExtentReportManager.setTest(test);
    }

    @After
    public void after(Scenario scenario) {
        try {
            if (scenario.isFailed()) {

                TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());

                String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
                ExtentTest test = ExtentReportManager.getTest();

                if (test != null) {
                    test.fail("Test failed. Screenshot below:", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                } else {
                    System.out.println("ExtentTest was null! Screenshot not attached to report.");
                }
            }
        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
        }finally {
            GWD.quitDriver();
        }
    }
}