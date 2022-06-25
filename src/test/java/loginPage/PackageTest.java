package loginPage;

import components.BaseClass;
import components.handlers.ContextHandler;
import components.screens.BaseBrowserScreen;
import components.screens.ModifyScreen;
import components.screens.SearchScreen;
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
    }

    @Test
    public void login_L_1(){
        System.out.println("START login_L_1");
        loginScreen.assertScreenIsDisplayedCorrectly();
        loginScreen.loginToAccount("leanne2", "password2");
        searchScreen.clickOpenMenu();
        searchScreen.clickLogOut();
        loginScreen.assertScreenIsDisplayedCorrectly();
    }

    @Test
    public void login_L_2(){
        System.out.println("START login_L_2");
        loginScreen.loginToAccount("leanne", "1234");
        loginScreen.checkPopUp();
        loginScreen.assertScreenIsDisplayedCorrectly();

    }

    @Test
    public void login_L_3(){
        System.out.println("START login_L_3");
        loginScreen.loginToAccount("leanne", "1234");
        loginScreen.checkPopUp();
        loginScreen.enterPassword("password");
        loginScreen.clickLogin();
        searchScreen.assertFirstScreenIsShown();
    }

    @Test
    public void login_L_4(){
        System.out.println("START login_L_4");
        searchScreen.clickOpenMenu();
        searchScreen.clickLogOut();
        loginScreen.loginToAccount("leanne", "password");
        searchScreen.assertFirstScreenIsShown();
        searchScreen.clickOpenMenu();
        searchScreen.clickLogOut();
        loginScreen.assertScreenIsDisplayedCorrectly();
    }

    @Test
    public void login_L_5(){
        System.out.println("START login_L_5");
        loginScreen.loginToAccount("1234", "password");
        loginScreen.checkPopUp();
    }

    @Test
    public void login_L_6(){
        System.out.println("START login_L_6");
        loginScreen.loginToAccount("leanne.graham@gmail.com", "password");
        searchScreen.clickOpenMenu();
        searchScreen.clickLogOut();
        loginScreen.assertScreenIsDisplayedCorrectly();
    }

    @Test
    public void login_L_7(){
        System.out.println("START login_L_7");
        loginScreen.clickLogin();
        loginScreen.assertValidationFields();
    }


}
