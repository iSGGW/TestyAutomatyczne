package loginPage;

import components.screens.BaseBrowserScreen;
import components.BaseClass;
import components.handlers.ContextHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
