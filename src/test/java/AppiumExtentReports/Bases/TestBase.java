package AppiumExtentReports.Bases;

import AppiumExtentReports.Utils.ExtentReportsUtils;
import AppiumExtentReports.Utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

public class TestBase {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    @BeforeSuite
    public void oneTimeBefore() {
        ExtentReportsUtils.createReport();
    }

    @BeforeMethod
    public void beforeTest(Method method)throws IOException {
        inicializaDriver(true);
        ExtentReportsUtils.addTest(method.getName());
    }

    public static void inicializaDriver(boolean deviceFarm)throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();

        //usuario aleatorio
        if(deviceFarm){
            String userName = "teste2244";
            String accessKey = "5zZT4n1xypsE6MgWLxLN";
            caps.setCapability("device", "Google Pixel 3");
            caps.setCapability("os_version", "9.0");
            caps.setCapability("project", "Cafe e Teste Projeto");
            caps.setCapability("build", "111");
            caps.setCapability("name", "Bstack-[Java] Sample Test");
            caps.setCapability("app", "bs://4190fe3ee6c0638be27405e3f246f3159707c9ab");

            driver = new AndroidDriver<MobileElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
        }
        else {
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "9");
            caps.setCapability("deviceName", "Pixel_2_API_28");
            caps.setCapability("app", Utils.returnPathProject() + "\\test\\resources\\app\\appSample.apk");

            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        ExtentReportsUtils.addTestResult(result);
        driver.quit();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentReportsUtils.generateReport();
    }


}
