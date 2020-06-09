package las3007.appium.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public abstract class BaseActivity {
    protected AppiumDriver<MobileElement> driver;

    public BaseActivity(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private Wait<AppiumDriver<MobileElement>> makeWait(int timeout) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    protected MobileElement waitForPresence(By elem) {
        return makeWait(10).until(new Function<MobileDriver<?>, MobileElement>() {
            public MobileElement apply(MobileDriver<?> driver) {
                return (MobileElement) driver.findElement(elem);
            }
        });
    }

    protected List<MobileElement> waitForListPresence(By elem) {
        return makeWait(10).until(new Function<MobileDriver<MobileElement>, List<MobileElement>>() {
            public List<MobileElement> apply(MobileDriver<MobileElement> driver) {
                return (List<MobileElement>) driver.findElements(elem);
            }
        });
    }

    protected MobileElement scrollUntilFound(String term) {
        return ((AndroidDriver<MobileElement>) driver)
                .findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                                + ".scrollIntoView(new UiSelector().textContains(\""+term+"\").instance(0))");
    }
}
