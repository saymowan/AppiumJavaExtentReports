package AppiumExtentReports.Screens;

import AppiumExtentReports.Bases.PageBase;
import org.openqa.selenium.By;

public class MenuScreen extends PageBase {


   By inputControlMenu = By.xpath("(//android.widget.TextView[@content-desc=\"Row Category Name\"])[4]");


    public void clicarMenuInputControl(){
        click(inputControlMenu);
    }


}
