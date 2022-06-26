package loginPage;

import components.BaseClass;
import components.handlers.ContextHandler;
import components.screens.BaseBrowserScreen;
import components.screens.ModifyScreen;
import components.screens.SearchScreen;
import configuration.ElementState;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginScreen;

import java.util.Map;

import static configuration.Utils.delay;

public class PackageTest extends BaseClass {
    private ContextHandler contextHandler;
    private BaseBrowserScreen baseBrowserScreen;
    private LoginScreen loginScreen;
    private SearchScreen searchScreen;
    private ModifyScreen modifyScreen;
    private ElementState elementState;

    @Override
    public void init(){
        contextHandler = new ContextHandler(device.getDriver());
        System.out.println("Start test, and activate chrome");
        device.startApp();
        baseBrowserScreen = new BaseBrowserScreen(device);
        baseBrowserScreen.enterSite("https://20.218.104.224:8443/inz/build/#/auth");
        Assert.assertTrue(contextHandler.switchToWebContext());
        baseBrowserScreen.enterConnectionNotPrivate();
        loginScreen = new LoginScreen(device);
        searchScreen = new SearchScreen(device);
        modifyScreen = new ModifyScreen(device);
        elementState = new ElementState(device);
    }

    @Test(priority = 1)
    public void login_L_1(){
        System.out.println("START login_L_1");
        loginScreen.assertScreenIsDisplayedCorrectly();
        loginScreen.loginToAccount("leanne2", "password2");
        searchScreen.clickOpenMenu().clickLogOut();
        loginScreen.assertScreenIsDisplayedCorrectly();
    }

    @Test(priority = 2)
    public void login_L_2(){
        System.out.println("START login_L_2");
        loginScreen.loginToAccount("leanne", "1234");
        loginScreen.checkPopUp();
        loginScreen.assertScreenIsDisplayedCorrectly();

    }

    @Test(priority = 3)
    public void login_L_3(){
        System.out.println("START login_L_3");
        loginScreen.loginToAccount("leanne", "1234");
        loginScreen.checkPopUp();
        loginScreen.enterPassword("password");
        loginScreen.clickLogin();
        searchScreen.assertFirstScreenIsShown();
    }

    @Test(priority = 4)
    public void login_L_4(){
        System.out.println("START login_L_4");
        searchScreen.clickOpenMenu().clickLogOut();
        loginScreen.loginToAccount("leanne", "password");
        searchScreen.assertFirstScreenIsShown();
        searchScreen.clickOpenMenu().clickLogOut();
        loginScreen.assertScreenIsDisplayedCorrectly();
    }

    @Test(priority = 5)
    public void login_L_5(){
        System.out.println("START login_L_5");
        loginScreen.loginToAccount("1234", "password");
        loginScreen.checkPopUp();
    }

    @Test(priority = 6)
    public void login_L_6(){
        System.out.println("START login_L_6");
        loginScreen.loginToAccount("leanne.graham@gmail.com", "password");
        searchScreen.clickOpenMenu().clickLogOut();
        loginScreen.assertScreenIsDisplayedCorrectly();
    }

    @Test(priority = 7)
    public void login_L_7(){
        System.out.println("START login_L_7");
        loginScreen.clickLogin();
        loginScreen.assertValidationFields();
    }

    @Test(priority = 8)
    public void Searching_W_1(){
        System.out.println("Start Searching_W_1");
        loginScreen.loginToAccount("leanne", "password");
        searchScreen.clickOpenMenu();
        searchScreen.closeMenu();
        searchScreen.assertSecondScreenIsShown();
    }

    @Test(priority = 9)
    public void Searching_W_2(){
        System.out.println("Start Searching_W_2");
        Assert.assertTrue(!searchScreen.getBtnNext().isEnabled());
    }

    @Test(priority = 10)
    public void Searching_W_3(){
        System.out.println("Start Searching_W_3");
        searchScreen.chooseBuilding("34");
        Assert.assertTrue(!searchScreen.getBtnNext().isEnabled());
    }

    @Test(priority = 11)
    public void Searching_W_4(){
        System.out.println("Start Searching_W_4");
        searchScreen.chooseFloor(1);
        Assert.assertTrue(!searchScreen.getBtnNext().isEnabled());
    }

    @Test(priority = 12)
    public void Searching_W_5(){
        System.out.println("Start Searching_W_5");
        searchScreen.chooseRoom(1);
        searchScreen.clickNext();
        searchScreen.assertSecondScreenIsShown();
        searchScreen.clickAddRandomJSON();
        searchScreen.clickNext();
        searchScreen.assertThirdScreen();
    }

    @Test(priority = 13)
    public void Modyfying_M_1(){
        System.out.println("Start Modyfying_M_1");
        searchScreen.clickOpenMenu().clickModify();
        modifyScreen.assertOnScreen();
    }

    @Test(priority = 14)
    public void Modyfying_M_2(){
        System.out.println("Start Modyfying_M_2");
        Assert.assertTrue(!elementState.isVisible(modifyScreen.getBtnAddItem()));
    }

    @Test(priority = 15)
    public void Modyfying_M_3(){
        System.out.println("Start Modyfying_M_3");
        modifyScreen.chooseBuilding("34");
        Assert.assertTrue(!elementState.isVisible(modifyScreen.getBtnAddItem()));
    }

    @Test(priority = 16)
    public void Modyfying_M_4(){
        System.out.println("Start Modyfying_M_4");
        modifyScreen.chooseFloor(1);
        Assert.assertTrue(!elementState.isVisible(modifyScreen.getBtnAddItem()));
    }

    @Test(priority = 17)
    public void Modyfying_M_5(){
        System.out.println("Start Modyfying_M_5");
        modifyScreen.chooseRoom(1);
        modifyScreen.assertMenuIsShown();
    }

    @Test(priority = 18)
    public void Modyfying_M_6(){
        System.out.println("Start Modyfying_M_6");
        modifyScreen.assertMenuIsShown();
        modifyScreen.clickAddItem();
        delay(500);
        modifyScreen.editItemFloor("Modyfying_M_6", "1");
        delay(500);
        modifyScreen.editItemRoom("Modyfying_M_6", "1");
    }

    @Test(priority = 19)
    public void Modyfying_M_7(){
        System.out.println("Start Modyfying_M_7");
        modifyScreen.assertMenuIsShown();
        modifyScreen.deleteItem("Krzeslo");
    }
}
