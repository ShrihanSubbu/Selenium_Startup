package org.example;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\uSER\\Desktop\\SeleniumSample\\src\\test\\java\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\uSER\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();*/
        driver.get("https://www.nike.com/in/");
        System.out.println("Page Title : " + driver.getTitle());
        /*assertTrue(driver.getTitle().contains("WebDriver"));
        driver.quit();*/
    }
}
