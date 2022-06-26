package components.screens;

import components.enums.Status;
import configuration.Device;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static configuration.Utils.delay;

public class ModifyScreen extends BaseBrowserScreen {
    private SoftAssert sa;

    @FindBy(xpath = "//h2")
    private WebElement lblHeader;

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

    @Getter
    @FindBy(xpath = "//span[text() = \"Dodaj przedmiot\"]/..")
    private WebElement btnAddItem;

    @FindBy(xpath = "//th[text() = \"Nazwa\"]")
    private WebElement tabHeadingName;

    @FindBy(xpath = "//th[text() = \"Piętro\"]")
    private WebElement tabHeadingFloor;

    @FindBy(xpath = "//th[text() = \"Pomieszczenie\"]")
    private WebElement tabHeadingRoom;

    @FindBy(xpath = "//th[text() = \"Status\"]")
    private WebElement tabHeadingStatus;

    @FindBy(xpath = "//th[text() = \"Akcje\"]")
    private WebElement tabHeadingActions;

    public ModifyScreen(Device device){
        super(device);
        PageFactory.initElements(new AppiumFieldDecorator(device.getDriver(), Duration.ofSeconds(10)), this);
        sa = new SoftAssert();
    }

    public void assertOnScreen(){
        System.out.println("Assert on screen");
        wait.waitUntilIsVisible(lblHeader);
        sa.assertTrue(elementState.isVisible(lblHeader));
        sa.assertTrue(elementState.isVisible(lblBuilding));
        sa.assertTrue(elementState.isVisible(lblFloor));
        sa.assertTrue(elementState.isVisible(lblClassRoom));
        sa.assertTrue(elementState.isVisible(lstSelectFloor));
        sa.assertTrue(elementState.isVisible(lstSelectBuilding));
        sa.assertTrue(elementState.isVisible(lstSelectRoom));
        sa.assertAll();
    }

    public void assertMenuIsShown(){
        System.out.println("Assert menu is shown");
        wait.waitUntilIsVisible(btnAddItem);
        sa.assertTrue(elementState.isVisible(btnAddItem));
        sa.assertTrue(elementState.isVisible(tabHeadingFloor));
        sa.assertTrue(elementState.isVisible(tabHeadingActions));
        sa.assertTrue(elementState.isVisible(tabHeadingName));
        sa.assertTrue(elementState.isVisible(tabHeadingRoom));
        sa.assertTrue(elementState.isVisible(tabHeadingStatus));
        sa.assertAll();
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

    public void clickAddItem(){
        System.out.println("Click add item");
        btnAddItem.click();
        String xpath = "//div[@class=\"editable-cell-value-wrap\" and text() = \"\"]/../..//div";
        delay(2000);
        WebElement element = device.getDriver().findElement(By.xpath(xpath));
        wait.waitUntilIsVisible(element);
        element.click();
        element.sendKeys("Modyfying_M_6");
        device.pressEnter();
    }

    public void chooseBuilding(String building){
        System.out.println("Choosing building " + building);
        lstSelectBuilding.click();
        delay(2000);
        String xpath = "//div[@class=\"ant-select-item-option-content\" and text()='" + building + "']";
        System.out.println(xpath);
        device.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void chooseFloor(int floor){
        System.out.println("Choosing floor " + floor);
        lstSelectFloor.click();
        delay(2000);
        if(floor > 4 || floor < 0) return;
        String xpath = "//div[@class=\"ant-select-item-option-content\" and text()='" + floor + "']";
        System.out.println(xpath);
        device.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void chooseRoom(int room){
        System.out.println("Choosing room " + room);
        lstSelectRoom.click();
        delay(2000);
        String xpath = "//div[@class = 'ant-select-item ant-select-item-option ant-select-item-option-active' and @title='" + room + "']";
        System.out.println(xpath);
        device.getDriver().findElement(By.xpath(xpath)).click();
    }

}
