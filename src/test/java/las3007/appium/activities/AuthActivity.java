package las3007.appium.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AuthActivity extends BaseActivity {

    private By emailBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText");
    private By passwordBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[6]/android.widget.EditText");
    private By loginBtnBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[9]/android.widget.Button");
    private By emptyEmailAlertBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]");
    private By emptyPasswordAlertBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]");
    private By incorrectCredentialsAlertBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View");
    private By notifOKBy = By.id("android:id/button2");

    public AuthActivity(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void submitLoginForm(String email, String password) {
        waitForPresence(emailBy).clear();
        waitForPresence(passwordBy).clear();

        waitForPresence(emailBy).sendKeys(email);
        waitForPresence(passwordBy).sendKeys(password);
        waitForPresence(loginBtnBy).click();
    }

    public void allowNotifcation() {
        waitForPresence(notifOKBy).click();
    }

    public String getEmptyEmailText() {
        return waitForPresence(emptyEmailAlertBy).getText();
    }

    public String getEmptyPasswordText() {
        return waitForPresence(emptyPasswordAlertBy).getText();
    }

    public String getIncorrectCredentialsText() {
        return waitForPresence(incorrectCredentialsAlertBy).getText();
    }
}
