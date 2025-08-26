package Reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final ExtentReports extentReports = new ExtentReports();

    // ✅ Force JVM to use IST timezone
    static {
        System.setProperty("user.timezone", "Asia/Kolkata");
    }

    public synchronized static ExtentReports createExtentReports() {

        // ✅ Report file path
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                new File(System.getProperty("user.dir") + "/AdminLTE.html"));

        // ✅ Report name
        reporter.config().setReportName("Admin LTE web automation Report");

        // ✅ Attach reporter
        extentReports.attachReporter(reporter);

        // ✅ System Info
        extentReports.setSystemInfo("Branch Name", "Production");
        extentReports.setSystemInfo("Author", "Test");
        extentReports.setSystemInfo("Platform", "Windows 10");

        return extentReports;
    }
}
