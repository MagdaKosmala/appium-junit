package las3007.appium.tests;

import las3007.appium.activities.AccountActivity;
import las3007.appium.activities.AuthActivity;
import las3007.appium.activities.HomeActivity;
import las3007.appium.activities.LoginActivity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void testLoginEmptyCredentials() {
        LoginActivity login = new LoginActivity(driver);
        login.login();
        AuthActivity auth = new AuthActivity(driver);
        auth.submitLoginForm("","");

        assertEquals("Podaj adres e-mail", auth.getEmptyEmailText());
        assertEquals("Wprowadź hasło", auth.getEmptyPasswordText());
    }

    @Test
    void testLoginIncorrectCredentials() {
        LoginActivity login = new LoginActivity(driver);
        login.login();
        AuthActivity auth = new AuthActivity(driver);
        auth.submitLoginForm(email,"incorrect");

        assertEquals("Nieprawidłowe hasło", auth.getIncorrectCredentialsText());
    }

    @Test
    void testLoginSuccess() {
        LoginActivity login = new LoginActivity(driver);
        login.login();
        AuthActivity auth = new AuthActivity(driver);
        auth.submitLoginForm(email,password);
        auth.allowNotifcation();
        AccountActivity account = new HomeActivity(driver).loadAccout();

        assertTrue(account.isAccountIconPresent());
        assertEquals(username, account.getUsername());
    }
}
