package utilities;

import java.time.LocalDateTime;
import com.aventstack.extentreports.service.ExtentService;

public class ExtentReportManager {
    private static String browserName = "unknown";

    public static void setBrowserName(String name) {
        browserName = name;
    }

    public static void writeMetadata() {
        ExtentService.getInstance().setSystemInfo("Browser", browserName);
        ExtentService.getInstance().setSystemInfo("User Name", "Bug Fathers");
        ExtentService.getInstance().setSystemInfo("Team Name", "Team#4");
        ExtentService.getInstance().setSystemInfo("Execution Date", LocalDateTime.now().toString());
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Application Name", "TechnoStudy");
        ExtentService.getInstance().setSystemInfo("Department", "QA");
    }
}