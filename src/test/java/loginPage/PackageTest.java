package loginPage;

import components.BaseClass;
import components.handlers.ContextHandler;
import components.screens.BaseBrowserScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PackageTest extends BaseClass {
    private ContextHandler contextHandler;
    private BaseBrowserScreen baseBrowserScreen;

    @Test
    public void test(){
        contextHandler = new ContextHandler(device.getDriver());
        System.out.println("Start test, and activate chrome");
        device.startApp();
        System.out.println(device);
//        device.getDriver().getContextHandles().forEach(System.out::println);
        baseBrowserScreen = new BaseBrowserScreen(device);
        baseBrowserScreen.enterSite("https://20.218.104.224:8443/inz/build/search");
        Assert.assertTrue(contextHandler.switchToWebContext());
        baseBrowserScreen.enterConnectionNotPrivate();

    }

    @Test
    public void login_L_1(){

    }

    @Test
    public void login_L_2(){

    }
}
