package AppiumExtentReports.Utils;

import AppiumExtentReports.Bases.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

public class Utils {

    public static String getMethodNameByLevel(int level){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace[level].getMethodName();
    }

    public static String returnPathProject(){
            return System.getProperty("user.dir") + "\\";
    }

}
