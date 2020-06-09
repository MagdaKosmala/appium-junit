package las3007.appium.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginActivity extends BaseActivity {

    private By loginBy = By.id("com.imdb.mobile:id/imdb_auth_portal");

    public LoginActivity(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void login() {
       waitForPresence(loginBy).click();
    }
}
