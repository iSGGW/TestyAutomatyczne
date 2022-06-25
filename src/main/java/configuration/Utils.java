package configuration;

import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Utils {

    public static void delay(int milis){
        try{
            Thread.sleep(milis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void clearText(Device device, WebElement element){
//        for(int i = 0; i < element.getAttribute("value").length(); i++){
//            device.getDriver().pressKey(new KeyEvent(67));
//        }

        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }
}
