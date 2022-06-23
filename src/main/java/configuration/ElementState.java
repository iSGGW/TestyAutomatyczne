package configuration;

import org.openqa.selenium.WebElement;

public class ElementState {
    private Device device;

    public ElementState(Device device){
        this.device = device;
    }

    public boolean isVisible(WebElement element){
        if(element.isDisplayed()) return true;
        else return false;
    }
}
