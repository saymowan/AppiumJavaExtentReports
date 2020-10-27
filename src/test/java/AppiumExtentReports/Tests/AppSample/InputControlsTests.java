package AppiumExtentReports.Tests.AppSample;

import AppiumExtentReports.Screens.HomeScreen;
import AppiumExtentReports.Screens.InputControlsScreen;
import AppiumExtentReports.Screens.MenuScreen;
import AppiumExtentReports.Bases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputControlsTests
        extends TestBase {


    HomeScreen homeScreen;
    MenuScreen menuScreen;
    InputControlsScreen inputControlsScreen;


    @Test
    public void verificaTextField() {

        homeScreen = new HomeScreen();
        menuScreen = new MenuScreen();
        inputControlsScreen = new InputControlsScreen();

        //Arrange
        String inputText = "Preenchimento do campo teste";

        //Clicar no menu
        homeScreen.clicarMenu();

        //Clicar no menu “Input Controls”
        menuScreen.clicarMenuInputControl();

        //Preencher campo TextField
        inputControlsScreen.fillTextField(inputText);

        //Verificar se o texto digitado está no campo
        Assert.assertEquals(inputControlsScreen.returnTextField(),inputText);
    }




}
