package Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize ExtentReports object (run only once per execution)
    public static synchronized ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    // Set ExtentTest for each thread
    public static synchronized void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    // Get ExtentTest for the current thread
    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    // Clean up ThreadLocal after test is finished
    public static synchronized void removeTest() {
        extentTest.remove();
    }
}
