package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static data.Errors.*;
import static data.Logins.STANDARD_USER;
import static data.Logins.WRONG_USER;
import static data.Passwords.VALID_PASSWORD;
import static data.Passwords.WRONG_PASSWORD;

@DisplayName("Login tests")
public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Positive login")
    public void positiveLoginTest() {
        new LoginPage(driver)
                .login(STANDARD_USER, VALID_PASSWORD)
                .checkPageTitle("Products");
    }

    @Test
    @DisplayName("Username without VALID_PASSWORD")
    public void onlyUsernameTest() {
        new LoginPage(driver)
                .enterUsername(STANDARD_USER)
                .checkUsername(STANDARD_USER)
                .clickLogin()
                .checkError(PASSWORD_REQUIRED);
    }

    @Test
    @DisplayName("Password without username")
    public void onlyPasswordTest() {
        new LoginPage(driver)
                .enterPassword(STANDARD_USER)
                .checkPassword(STANDARD_USER)
                .clickLogin()
                .checkError(USERNAME_REQUIRED);
    }

    @Test
    @DisplayName("Incorrect username")
    public void wrongUsernameTest() {
        new LoginPage(driver)
                .enterUsername(WRONG_USER)
                .enterPassword(VALID_PASSWORD)
                .clickLogin()
                .checkError(WRONG_CREDENTIALS);
    }

    @Test
    @DisplayName("Incorrect VALID_PASSWORD")
    public void wrongPasswordTest() {
        new LoginPage(driver)
                .enterUsername(STANDARD_USER)
                .enterPassword(WRONG_PASSWORD)
                .clickLogin()
                .checkError(WRONG_CREDENTIALS);
    }

}
