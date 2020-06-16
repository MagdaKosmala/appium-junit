package las3007.appium.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AccountActivity extends BaseActivity{

    private By accountIconBy = By.id("com.imdb.mobile:id/account_icon");
    private By usernameBy = By.id("com.imdb.mobile:id/username");
    private By watchlistBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout");

    public AccountActivity(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getUsername() {
        return waitForPresence(usernameBy).getText();
    }

    public boolean isAccountIconPresent() {
        return (waitForPresence(accountIconBy) == null ? false : true );
    }

    public WatchlistActivity loadWatchlist() {
        waitForPresence(watchlistBy).click();
        return new WatchlistActivity(driver);
    }
}
