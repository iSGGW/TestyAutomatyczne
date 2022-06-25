package configuration;

import org.openqa.selenium.WebElement;

public class ElementState {
    private Device device;

    public ElementState(Device device){
        this.device = device;
    }

    public boolean isVisible(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
