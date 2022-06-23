package components.screens;

import configuration.Device;
import configuration.ElementState;
import configuration.Wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static configuration.Utils.delay;

public class BaseBrowserScreen {
    protected Device device;
    private Wait wait;
    private ElementState elementState;

    @AndroidFindBy(id = "com.android.chrome:id/search_box_text")
    private MobileElement textBox;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private MobileElement urlBar;

    @FindBy(xpath = "//button[@id=\"details-button\"]")
    private WebElement detailsButton;

    @FindBy(xpath = "//a[contains(@href,'#') and @id='proceed-link']")
    private WebElement proceed;

    public BaseBrowserScreen(Device d){
        PageFactory.initElements(new AppiumFieldDecorator(d.getDriver(), Duration.ofSeconds(10)), this);
        device = d;
        wait = new Wait(device);
    }

    public void enterSite(String url){
//        wait.waitUntilIsVisible(textBox);
        textBox.click();
        wait.waitUntilIsVisible(urlBar);
        urlBar.sendKeys(url);
        device.pressEnter();
    }

    public void enterConnectionNotPrivate(){
        if(elementState.isVisible(detailsButton)){
            detailsButton.click();
            delay(1000);
            proceed.click();
        }
    }

}
