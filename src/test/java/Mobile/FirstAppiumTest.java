package Mobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAppiumTest{

    private AppiumDriver driver;

    @Test
    public void runMessagesTest() throws MalformedURLException {
        // 1. Create a AppiumDriver
        // 1.1 Set the capabilities of the driver

        // Appium 1.x
        // DesiredCapabilities capabilities = new DesiredCapabilities();

        // Appium 2.x
        UiAutomator2Options capabilities = new UiAutomator2Options();

        /*capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "Priya");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
        capabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);
        capabilities.setCapability("fullReset", false);*/

        capabilities.setDeviceName("Priya");
        capabilities.setPlatformName("Android");
        capabilities.setPlatformVersion("15");
        capabilities.setAutomationName("UiAutomator2");
        capabilities.setAppPackage("com.google.android.apps.messaging");
        capabilities.setAppActivity("com.google.android.apps.messaging.ui.ConversationListActivity");
        capabilities.noReset();
        capabilities.ignoreHiddenApiPolicyError();
        driver = new AppiumDriver(new URL("http://192.168.0.12:4723/"),
                capabilities);
        /*driver = new AppiumDriver(getAppiumServerUrl(),
                capabilities);*/
        System.out.println("Created AppiumDriver");

        // 2. Orchestrate the test scenario
        try {
            driver.findElement(By.xpath("(//android.widget.TextView[@content-desc='Messages'])[2]"))
                    .click();
            //com.google.android.apps.messaging:id/conversation_list_google_tos_popup_positive_button
            /*driver.findElement(By.id("android:id/button2"))
                    .click();
            driver.findElement(By.id("android:id/button1"))
                    .click();*/
        } catch (Exception e) {
            System.out.println("Agree button not seen");
        }
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Start chat']")).click();
        /*driver.findElement(AppiumBy.accessibilityId("Switch between entering text and numbers"))
                .click();*/
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='ContactSearchField']")).sendKeys("Yalamanda");
        waitFor(5);
        if (null != driver) {
            System.out.println("Close the driver");
            driver.quit();
        }
    }

    private void waitFor(int numberOfSeconds) {
        try {
            System.out.println("Sleep for " + numberOfSeconds);
            Thread.sleep(numberOfSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
