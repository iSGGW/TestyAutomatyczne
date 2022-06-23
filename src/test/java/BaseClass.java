import components.handlers.ContextHandler;
import configuration.Device;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class BaseClass {
    private AndroidDriver driver;
    private Device device;
    private String udid;
    private ContextHandler contextHandler;
    private BaseBrowserScreen baseBrowserScreen;

    @BeforeTest
    public void setup() throws IOException{
        device = new Device();
        System.out.println("START build capabilities");
        udid = device.getUDID();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, udid);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        device.setDriver(url, caps);

        contextHandler = new ContextHandler(device.getDriver());
    }

    @Test
    public void test(){
        System.out.println("Start test, and activate chrome");
        device.startApp();
//        device.getDriver().getContextHandles().forEach(System.out::println);
        baseBrowserScreen = new BaseBrowserScreen(device);
        baseBrowserScreen.enterSite("");
        Assert.assertTrue(contextHandler.switchToWebContext());

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
