package runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utilities.GWD;

import java.time.LocalDateTime;

@CucumberOptions(
        features = {"src/test/java/featureFiles/AccessToEJunkieHomePage.feature"},
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class AccessToEJunkieHomePageRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browserType")
    public void setUp(String browserType) {
        GWD.threadBrowserName.set(browserType);
    }

//    @AfterClass
//    public void writeExtendReport() {
//        ExtentService.getInstance().setSystemInfo("--------------------", "--------------------");
//        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name"));
//        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        ExtentService.getInstance().setSystemInfo("Browser", GWD.threadBrowserName.get());
//        ExtentService.getInstance().setSystemInfo("Execution Date", LocalDateTime.now().toString());
//        ExtentService.getInstance().setSystemInfo("User Name", "Bug Fathers");
//        ExtentService.getInstance().setSystemInfo("Team Name", "Team#4");
//        ExtentService.getInstance().setSystemInfo("Application Name", "TechnoStudy");
//        ExtentService.getInstance().setSystemInfo("Test Tag", "BlogPage");
//        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
//        ExtentService.getInstance().setSystemInfo("Department", "QA");
//    }
}