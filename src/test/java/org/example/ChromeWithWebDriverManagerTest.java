package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeWithWebDriverManagerTest {


    private static Logger logger;

    WebDriver driver;
    @BeforeTest
    public void setup() throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        logger = LogManager.getLogger(ChromeWithWebDriverManagerTest.class);
        logger.info("logger1");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

       /* BufferedReader reader = new BufferedReader(new FileReader("C://Users//uSER//Desktop//SeleniumSample//src//test//java//resources//log4j2.properties"));
        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //DOMConfigurator.configure("log4j.xml");

    }
    @Test
    void checkTheUrl() throws InterruptedException {

        driver.get("https://www.nike.com/in/");
        logger.info("navigate to nike home page");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(".//a[text()='Men']"))).perform();
        driver.findElement(By.xpath("(.//p[text()='Shorts'])[1]")).click();
        logger.info("Select Shorts option from Mens");


        /*Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(text(),'Jordan Sport')]//following::div[contains(text(),'FIT Mesh Diamond Shorts')]/parent::div/preceding-sibling::div[text()='Just In']"))).click();
*/
        WebElement item = driver.findElement(By.xpath(".//div[contains(text(),'Jordan Sport')]//following::div[contains(text(),'FIT Mesh Diamond Shorts')]/parent::div/preceding-sibling::div[text()='Just In']"));

        actions.click(item).perform();
        logger.info("Select particular product");
        /*JavascriptExecutor js = (JavascriptExecutor)driver;

        // Call the JavascriptExecutor methods
        js.executeScript("arguments[0].click();", item);*/

        String url = driver.getCurrentUrl();
        System.out.println(url);
        //assertTrue(url.contains("lambdatest"));
    }
    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
