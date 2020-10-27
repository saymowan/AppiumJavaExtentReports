package AppiumExtentReports.Screens;
import AppiumExtentReports.Bases.PageBase;
import org.openqa.selenium.By;

public class InputControlsScreen extends PageBase {


    By inputTextField = By.xpath("//android.widget.EditText[@content-desc='Text Input Control']");

    By checkBoxTitle = By.xpath("//android.widget.TextView[@text='Checkbox']");

     public void fillTextField(String value){
        sendKeys(inputTextField, value);
    }

    public String returnTextField(){
        return getText(inputTextField);
    }


}
