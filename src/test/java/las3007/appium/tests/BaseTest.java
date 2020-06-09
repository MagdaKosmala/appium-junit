package las3007.appium.tests;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import las3007.appium.utilis.PropertyReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public abstract class BaseTest {
    private static DesiredCapabilities dc;
    private static URL url;

    protected AppiumDriver<MobileElement> driver;

    protected String email, password, username;

    @BeforeAll
    public static void prepareCapabilities() throws MalformedURLException {
        dc = new DesiredCapabilities();
        dc.setCapability(PLATFORM_NAME, "Android");
        dc.setCapability(PLATFORM_VERSION, "10.0");
        dc.setCapability(DEVICE_NAME, "Mi A3");
        dc.setCapability(UDID, "c9f22cc82099");
        dc.setCapability(AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(AUTO_GRANT_PERMISSIONS, "true");
        dc.setCapability(APP_PACKAGE, "com.imdb.mobile");
        dc.setCapability(APP_ACTIVITY, "com.imdb.mobile.HomeActivity");

        //https://appiumpro.com/editions/43-setting-ios-app-permissions-automatically
        dc.setCapability("permissions", "{\"com.imdb.mobile\": {\"location\": \"inuse\"}}");

        url = new URL("http://localhost:4723/wd/hub");
    }

    @BeforeEach
    public void setUp() {
        driver = new AndroidDriver<>(url, dc);

        try {
            getProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void getProperties() throws IOException {
        email = PropertyReader.getValue("email");
        password = PropertyReader.getValue("password");
        username = PropertyReader.getValue("username");
    }
}
