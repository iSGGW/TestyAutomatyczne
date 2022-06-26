package components.screens;

import configuration.Device;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static configuration.Utils.delay;

public class Menu extends BaseBrowserScreen{

    @Getter
    @FindBy(xpath = "//a[@href=\"#/logout\"]")
    private WebElement btnLogout;

    @FindBy(xpath = "//a[@href=\"#/modify\"]")
    private WebElement btnModify;

    @FindBy(xpath = "//a[@href=\"#/search\"]")
    private WebElement btnSearch;

    public Menu(Device d){
        super(d);
        PageFactory.initElements(new AppiumFieldDecorator(d.getDriver(), Duration.ofSeconds(10)), this);

    }

    public void clickLogOut(){
        delay(500);
        btnLogout.click();
    }

    public void clickModify(){
        delay(500);
        btnModify.click();
    }
}
