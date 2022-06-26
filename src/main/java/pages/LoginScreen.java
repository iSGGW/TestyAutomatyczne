package pages;

import components.screens.SearchScreen;
import configuration.Device;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static configuration.Utils.clearText;
import static configuration.Utils.delay;

public class LoginScreen extends BasicScreen {

    @FindBy(xpath = "//label[text()=\"Nazwa użytkownika\"]")
    private WebElement lblLogin;

    @FindBy(xpath = "//input[@name=\"usernameOrEmail\"]")
    private WebElement fieldLogin;

    @FindBy(xpath = "//label[text()=\"Hasło\"]")
    private WebElement lblPassword;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//div[text() = \"Nie udało się zalogować\"]")
    private WebElement popUpUnsuccessfullLogin;

    @FindBy(xpath = "//input[@class=\"ant-input ant-input-status-error\"]")
    private WebElement validateLogin;

    @FindBy(xpath = "//span[@class=\"ant-input-affix-wrapper ant-input-password ant-input-affix-wrapper-status-error\"]")
    private WebElement validatePassword;

    public LoginScreen(Device device){
        super(device);
        PageFactory.initElements(new AppiumFieldDecorator(device.getDriver(), Duration.ofSeconds(10)), this);
    }

    public void loginToAccount(String login, String password){
        System.out.println("Login to account: " + login + " " + password);
        enterLogin(login);
        enterPassword(password);
        btnSubmit.click();
    }

    public void enterLogin(String login){
        fieldLogin.click();
        delay(500);
        clearText(device, fieldLogin);
        delay(500);
        fieldLogin.sendKeys(login);
        device.getDriver().hideKeyboard();
    }

    public void enterPassword(String password){
        fieldPassword.click();
        delay(500);
        clearText(device, fieldPassword);
        delay(500);
        fieldPassword.sendKeys(password);
        device.getDriver().hideKeyboard();
    }

    public void clickLogin(){
        System.out.println("Click login");
        btnSubmit.click();
    }

    public void checkPopUp(){
        System.out.println("Checking popUp");
        wait.waitUntilIsVisible(popUpUnsuccessfullLogin);
    }

    public void assertScreenIsDisplayedCorrectly(){
        System.out.println("Assert screen is displayed properley: " + getClass());
        wait.waitUntilIsVisible(lblLogin);
        sa.assertTrue(elementState.isVisible(lblLogin));
        sa.assertTrue(elementState.isVisible(fieldLogin));
        sa.assertTrue(elementState.isVisible(lblPassword));
        sa.assertTrue(elementState.isVisible(fieldPassword));
        sa.assertTrue(elementState.isVisible(btnSubmit));
        sa.assertAll();
    }

    public void assertValidationFields(){
        System.out.println("Assert validation fields");
        wait.waitUntilIsVisible(validateLogin);
        sa.assertTrue(elementState.isVisible(validateLogin));
        sa.assertTrue(elementState.isVisible(validatePassword));
        sa.assertAll();
    }
}
