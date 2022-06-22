import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public abstract class BasicScreen {
    protected AppiumDriver driver;

    public BasicScreen(AppiumDriver driver){
        this.driver = driver;
    }
}
