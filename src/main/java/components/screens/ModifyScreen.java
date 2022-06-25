package components.screens;

import components.enums.Status;
import configuration.Device;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ModifyScreen extends BaseBrowserScreen {
    @FindBy(xpath = "//label[text() ='Budynek']")
    private WebElement lblBuilding;

    @FindBy(xpath = "//label[text() ='Piętro']")
    private WebElement lblFloor;

    @FindBy(xpath = "//label[text() ='Sala']")
    private WebElement lblClassRoom;

    @FindBy(xpath = "//span[@title=\"Wybierz budynek\"]")
    private WebElement lstSelectBuilding;

    @FindBy(xpath = "//span[text() ='Wybierz piętro']")
    private WebElement lstSelectFloor;

    @FindBy(xpath = "//span[text() ='Wybierz pomieszczenie']")
    private WebElement lstSelectRoom;

    @FindBy(xpath = "//a[text()= \"Usuń\"]")
    private WebElement btnDelete;

    public ModifyScreen(Device device){
        super(device);
        PageFactory.initElements(new AppiumFieldDecorator(device.getDriver(), Duration.ofSeconds(10)), this);
    }

    public void deleteItem(String name){
        String xpath = "//div[@class=\"editable-cell-value-wrap\" and text()='" + name + "']/../..//a";
        device.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void editItemName(String name, String newName){
        String xpath = "//div[@class=\"editable-cell-value-wrap\" and text()='" + name + "']";
        WebElement element = device.getDriver().findElement(By.xpath(xpath));
        element.click();
        element.clear();
        element.sendKeys(newName);
        device.pressEnter();
    }

    public void editItemStatus(String name, Status status){
        String xpath = "//div[@class=\"editable-cell-value-wrap\" and text()='" + name + "']/../../td[@class=\"ant-table-cell\"])[2]";
        WebElement element = device.getDriver().findElement(By.xpath(xpath));
        element.click();
        element.clear();
        element.sendKeys(Integer.toString(status.getStatus()));
        device.pressEnter();
    }

    public void editItemFloor(String name, String floor){
        String xpath = "//div[@class=\"editable-cell-value-wrap\" and text()='" + name + "']/../../td[@class=\"ant-table-cell\"])[3]";
        WebElement element = device.getDriver().findElement(By.xpath(xpath));
        element.click();
        element.clear();
        element.sendKeys(floor);
        device.pressEnter();
    }

    public void editItemRoom(String name, String room){
        String xpath = "//div[@class=\"editable-cell-value-wrap\" and text()='" + name + "']/../../td[@class=\"ant-table-cell\"])[4]";
        WebElement element = device.getDriver().findElement(By.xpath(xpath));
        element.click();
        element.clear();
        element.sendKeys(room);
        device.pressEnter();
    }
}
