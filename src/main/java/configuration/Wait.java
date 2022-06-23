package configuration;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Wait {

    private WebDriverWait driverWait;
    private Device device;

    public Wait(Device d){
        device = d;
        driverWait = device.getWebDriverWait();
    }

    public MobileElement waitUntilIsVisible(By element){
        return (MobileElement) waitUntil(visibilityOfElementLocated(element));
    }

    public void waitUntilIsVisible(WebElement element){
        waitUntil(visibilityOf(element));
    }

    private <T> T waitUntil(final ExpectedCondition<T> condition){
        return driverWait.until(condition);
    }
}
