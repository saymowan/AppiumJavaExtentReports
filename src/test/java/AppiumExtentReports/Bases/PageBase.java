package AppiumExtentReports.Bases;
import AppiumExtentReports.Utils.ExtentReportsUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    private AppiumDriver driver = null;
    private WebDriverWait wait = null;

    public PageBase(){
        driver = TestBase.getDriver();
        wait = new WebDriverWait (driver, 90);
    } //fim construtor

    //By locator
    protected MobileElement waitForElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        MobileElement element = (MobileElement) driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    protected void click(By locator){
        waitForElement(locator).click();
        ExtentReportsUtils.addTestInfo(3, "");
    }

    protected void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
        ExtentReportsUtils.addTestInfo(3, text);
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        ExtentReportsUtils.addTestInfo(3, text);
        return text;
    }

}//fim classe
