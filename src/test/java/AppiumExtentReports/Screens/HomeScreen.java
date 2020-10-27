package AppiumExtentReports.Screens;

import AppiumExtentReports.Bases.PageBase;
import org.openqa.selenium.By;

public class HomeScreen extends PageBase {


    By menuButton = By.xpath("//android.widget.ImageButton[@content-desc=\"ReferenceApp\"]");

    public void clicarMenu(){
        click(menuButton);
    }





}
