package AppiumExtentReports.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsUtils {


    public static ExtentReports EXTENT_REPORT = null;
    public static ExtentHtmlReporter HTML_REPORTER = null;
    public static ExtentTest TEST;
    public static ExtentTest SCENARIO;
    public static String reportPath = "target/reports";
    public static String fileName = "AppiumExtentReports" + getNowDate("yyyy-MM-dd_HH-mm-ss") + ".html" ;
    private static String testNameMemory = null;


    public static void createReport() {
        createFolderReport();
        EXTENT_REPORT = new ExtentReports();
        HTML_REPORTER = new ExtentHtmlReporter(reportPath+"/"+fileName);
        EXTENT_REPORT.attachReporter(HTML_REPORTER);
    }

    public static void addTest(String testName) {
        testNameMemory = testName;
        TEST = EXTENT_REPORT.createTest(testName);
    }

    public static void addTestInfo(int methodLevel, String text){
        String methodName = Utils.getMethodNameByLevel(methodLevel);
        String testName = testNameMemory;
        TEST.log(Status.INFO, methodName + " || " + text);
    }

    public static void addTestResult(ITestResult result) {
        switch (result.getStatus())
        {
            case ITestResult.FAILURE:
                TEST.log(Status.FAIL, result.getThrowable().toString());
                break;
            case ITestResult.SKIP:
                TEST.log(Status.SKIP, result.getThrowable().toString());
                break;
            default:
                TEST.log(Status.PASS, "Sucesso");
                break;
        }
    }

    public static void generateReport(){
        EXTENT_REPORT.flush();
    }


    public static String getNowDate(String mask){
        DateFormat dateFormat = new SimpleDateFormat(mask);
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static void createFolderReport(){
        File dir = new File(System.getProperty("user.dir") + "\\target\\reports");
        dir.mkdir();
    }


}
