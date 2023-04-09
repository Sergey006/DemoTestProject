package pages;

import data.Errors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Utils;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    private WebElement errorLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String login) {
        userNameField.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage checkUsername(String value) {
        assertThat(getLoginValue()).isEqualTo(value);
        return this;
    }

    public LoginPage checkPassword(String value) {
        assertThat(getPasswordValue()).isEqualTo(value);
        return this;
    }

    public LoginPage checkError(Errors value) {
        assertThat(getErrorValue()).isEqualTo(String.valueOf(value));
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    public ProductsPage login(String login, String password) {
        enterUsername(login);
        enterPassword(password);
        clickLogin();
        return new ProductsPage(driver);
    }

    private String getLoginValue() {
        return Utils.getText(userNameField);
    }

    private String getPasswordValue() {
        return Utils.getText(passwordField);
    }

    private String getErrorValue() {
        return Utils.getText(errorLabel);
    }
}
