package pages;

import configuration.Device;
import configuration.ElementState;
import configuration.Wait;
import org.testng.asserts.SoftAssert;

public abstract class BasicScreen {
    protected Device device;
    protected ElementState elementState;
    protected SoftAssert sa;
    protected Wait wait;

    public BasicScreen(Device device){
        this.device = device;
        elementState = new ElementState(device);
        sa = new SoftAssert();
        wait = new Wait(device);
    }
}
