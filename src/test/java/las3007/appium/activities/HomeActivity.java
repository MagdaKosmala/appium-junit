package las3007.appium.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomeActivity extends BaseActivity {

    private By menuAccountBy = By.id("com.imdb.mobile:id/menu_account");

    public HomeActivity(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public AccountActivity loadAccout() {
        waitForPresence(menuAccountBy).click();
        return  new AccountActivity(driver);
    }
}
