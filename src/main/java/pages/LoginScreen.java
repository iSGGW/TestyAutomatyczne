package pages;

import configuration.Device;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LoginScreen(Device device){
        super(device);
    }

    public void loginToAccount(String login, String password){
        fieldLogin.click();
        fieldLogin.sendKeys(login);
        device.getDriver().hideKeyboard();
        fieldPassword.click();
        fieldPassword.sendKeys(password);
        device.getDriver().hideKeyboard();
    }

    public void assertScreenIsDisplayedCorrectly(){
        wait.waitUntilIsVisible(lblLogin);
        sa.assertTrue(elementState.isVisible(lblLogin));
        sa.assertTrue(elementState.isVisible(fieldLogin));
        sa.assertTrue(elementState.isVisible(lblPassword));
        sa.assertTrue(elementState.isVisible(fieldPassword));
        sa.assertTrue(elementState.isVisible(btnSubmit));
        sa.assertAll();
    }
}
