package components.screens;

import configuration.Device;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseBrowserScreen{

    @FindBy(xpath = "//span[text()='Otwórz menu']")
    private WebElement lblOpenMenu;

    @FindBy(xpath = "//div[text()='Wybór pomieszczenia']")
    private WebElement lblSelectRoom;

    @FindBy(xpath = "//div[text()='Skanowanie przedmiotów']")
    private WebElement lblScanningItems;

    @FindBy(xpath = "//div[text()='Wynik inwentaryzacji']")
    private WebElement lblResultInventarization;

    @FindBy(xpath = "//label[text() ='Piętro']")
    private WebElement lblFloor;

    @FindBy(xpath = "//label[text() ='Sala']")
    private WebElement lblClassRoom;

    @FindBy(xpath = "//span[text() ='Wybierz piętro']")
    private WebElement lstSelectFloor;

    @FindBy(xpath = "//span[text() ='Wybierz pomieszczenie']")
    private WebElement lstSelectRoom;

    @FindBy(xpath = "//button[contains(@class, 'ant-btn ant-btn-primary')]")
    private WebElement btnNext;

    public SearchScreen(Device d){
        super(d);
    }

    public void assertScreenIsShown(){

    }
}
