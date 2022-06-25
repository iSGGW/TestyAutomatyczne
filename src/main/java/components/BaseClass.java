package components;

import configuration.Device;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BaseClass {
    protected AndroidDriver driver;
    protected Device device;
    private String udid;

    public final String adminLogin = "leanne";
    public final String adminPassword = "password";
    public final String userLogin = "leanne2";
    public final String userPassword = "password2";

    @BeforeSuite
    public void setup() throws IOException{
        device = new Device();
        System.out.println("START build capabilities");
        udid = device.getUDID();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, udid);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        device.setDriver(url, caps);
        driver = (AndroidDriver) device.getDriver();
        try{
            device.getDriver().terminateApp(device.getBundleId());
        }catch (Exception e){
            e.printStackTrace();
        }
        init();
    }

    public void init(){
        System.out.println("Empty init");
    }

    @AfterSuite
    public void tearDown(){
        driver.terminateApp(device.getBundleId());
        driver.quit();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("--------------------------------------------------");
    }
}
