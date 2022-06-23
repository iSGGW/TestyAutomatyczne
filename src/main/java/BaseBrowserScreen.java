import configuration.Device;
import configuration.Wait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BaseBrowserScreen {
    Device device;
    private Wait wait;

    @AndroidFindBy(id = "com.android.chrome:id/search_box_text")
    private MobileElement textBox;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private MobileElement urlBar;

    public BaseBrowserScreen(Device d){
        device = d;
    }

    public void enterSite(String url){
        textBox.click();
        wait.waitUntilIsVisible(urlBar);
        urlBar.sendKeys(url);
    }

}
