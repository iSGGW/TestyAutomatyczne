package components.screens;

import configuration.Device;
import configuration.ElementState;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static configuration.Utils.delay;

public class SearchScreen extends BaseBrowserScreen{
    private ElementState elementState;
    private SoftAssert sa;

    @Getter
    @FindBy(xpath = "//span[text()='Otwórz menu']")
    private WebElement lblOpenMenu;

    @FindBy(xpath = "//span[@class=\"anticon anticon-left\"]/..")
    private WebElement lblCloseMenu;

    @FindBy(xpath = "//div[text()='Wybór pomieszczenia']")
    private WebElement lblSelectRoom;

    @FindBy(xpath = "//div[text()='Skanowanie przedmiotów']")
    private WebElement lblScanningItems;

    @FindBy(xpath = "//div[text()='Wynik inwentaryzacji']")
    private WebElement lblResultInventarization;

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

    @Getter
    @FindBy(xpath = "//button[contains(@class, 'ant-btn ant-btn-primary')]")
    private WebElement btnNext;

    @FindBy(xpath = "//span[text()=\"add random JSON\"]/..")
    private WebElement btnAddRandomJSON;

    @FindBy(xpath = "//h3")
    private WebElement lblScannedID;

    @FindBy(xpath = "//h3")
    private WebElement lblDetails;

    @FindBy(xpath = "//span[text()=\"Wybierz przedmiot by zobaczyć szczegóły\"]")
    private WebElement lblChooseItem;

    @FindBy(xpath = "//span[@aria-label=\"left\"]/..")
    private WebElement buttonLeft;

    @FindBy(xpath = "(//span[@class=\"anticon anticon-right\"])[2]/..")
    private WebElement buttonRight;

    @FindBy(xpath = "//th[text() = \"ID\"]")
    private WebElement tabHeadingID;

    @FindBy(xpath = "//th[text() = \"Nazwa\"]")
    private WebElement tabHeadingName;

    @FindBy(xpath = "//th[text() = \"Piętro\"]")
    private WebElement tabHeadingFloor;

    @FindBy(xpath = "//th[text() = \"Pomieszczenie\"]")
    private WebElement tabHeadingRoom;

    @FindBy(xpath = "//th[text() = \"Status\"]")
    private WebElement tabHeadingStatus;

    public SearchScreen(Device d){
        super(d);
        PageFactory.initElements(new AppiumFieldDecorator(d.getDriver(), Duration.ofSeconds(10)), this);
        elementState = new ElementState(device);
        sa = new SoftAssert();
    }

    public void assertFirstScreenIsShown(){
        System.out.println("Assert first screen is shown");
        sa.assertTrue(elementState.isVisible(lblOpenMenu));
        sa.assertTrue(elementState.isVisible(lblSelectRoom));
        sa.assertTrue(elementState.isVisible(lblScanningItems));
        sa.assertTrue(elementState.isVisible(lblResultInventarization));
        sa.assertTrue(elementState.isVisible(lblFloor));
        sa.assertTrue(elementState.isVisible(lblClassRoom));
        sa.assertTrue(elementState.isVisible(lblSelectRoom));
        sa.assertTrue(elementState.isVisible(lstSelectFloor));
        sa.assertTrue(elementState.isVisible(lstSelectRoom));
        sa.assertTrue(elementState.isVisible(btnNext));
        sa.assertAll();
    }

    public void assertSecondScreenIsShown(){
        System.out.println("Assert second screen is shown");
        sa.assertTrue(elementState.isVisible(lblOpenMenu));
        sa.assertTrue(elementState.isVisible(lblSelectRoom));
        sa.assertTrue(elementState.isVisible(lblScanningItems));
        sa.assertTrue(elementState.isVisible(lblResultInventarization));
        sa.assertTrue(elementState.isVisible(lblScannedID));
        sa.assertTrue(elementState.isVisible(btnAddRandomJSON));
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

    public void clickAddRandomJSON(){
        System.out.println("Click add random JSON");
        btnAddRandomJSON.click();
    }

    public void clickNext(){
        System.out.println("Click next");
        if(!btnNext.isEnabled()){
            System.out.println("Button is disabled!!");
            return;
        }else{
            btnNext.click();
        }
    }

    public Menu clickOpenMenu(){
        System.out.println("Open menu");
        wait.waitUntilIsVisible(lblOpenMenu);
        lblOpenMenu.click();
        wait.waitUntilIsVisible(new Menu(device).getBtnLogout());
        return new Menu(device);
    }

    public void closeMenu(){
        System.out.println("Close menu");
        lblCloseMenu.click();
        wait.waitUntilIsVisible(lblOpenMenu);
    }

    private boolean findInventarizationItem(String id, String name, String floor, String room, String status){
        System.out.println("Find inventarization item" + id + " " + name + " " + floor + " " + room + " " + status);
        try{
            device.getDriver().findElement(By.xpath("//th[text() = '" + id + "']"));
            device.getDriver().findElement(By.xpath("//th[text() = '" + name + "']"));
            device.getDriver().findElement(By.xpath("//th[text() = '" + floor + "']"));
            device.getDriver().findElement(By.xpath("//th[text() = '" + room + "']"));
            device.getDriver().findElement(By.xpath("//th[text() = '" + status + "']"));
            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Item was not found");
            return false;
        }

    }

    public void assertThirdScreen() {
        sa.assertTrue(elementState.isVisible(lblChooseItem));
        sa.assertTrue(elementState.isVisible(lblDetails));
        sa.assertTrue(elementState.isVisible(tabHeadingFloor));
        sa.assertTrue(elementState.isVisible(tabHeadingID));
        sa.assertTrue(elementState.isVisible(tabHeadingName));
        sa.assertTrue(elementState.isVisible(tabHeadingRoom));
        sa.assertTrue(elementState.isVisible(tabHeadingStatus));
        sa.assertTrue(elementState.isVisible(lblSelectRoom));
        sa.assertTrue(elementState.isVisible(lblScanningItems));
        sa.assertTrue(elementState.isVisible(lblResultInventarization));
    }

}
