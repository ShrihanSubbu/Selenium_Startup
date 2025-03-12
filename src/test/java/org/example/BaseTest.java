package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import reports.ExtentManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    String baseurl;
    //private static ThreadLocal<WebDriver> threadLocal= new ThreadLocal<>();

    @Parameters({"browser", "baseUrl"})
    @BeforeMethod
    public void setup(String browser, String url) throws InterruptedException {
        initialize(browser, url);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
        PageDriver.getDriver().quit();
    }

    private void initialize(String browser, String url) throws InterruptedException {
        baseurl = url;
        driver = getWebDriver(browser);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(url);
        logger.info("navigate to url : {}", url);

    }

    private WebDriver getWebDriver(String browser) {
        WebDriver diver = null;
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            /*chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("disable-gpu");*/
            //driver = new ChromeDriver(chromeOptions);
            PageDriver.setDriver(new ChromeDriver(chromeOptions));
        }

        return PageDriver.getDriver();
    }


    @BeforeSuite
    public void beforeSuite() {
        ExtentManager.setExtent();
    }

    @AfterSuite
    public void afterSuite() {
        //service.shutdown();
        ExtentManager.endReport();
    }
}
