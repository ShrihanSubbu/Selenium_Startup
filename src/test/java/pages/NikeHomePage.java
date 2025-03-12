package pages;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NikeHomePage extends BaseTest {

    @FindBy(xpath = ".//a[text()='Men']")
    private WebElement menOption;

    @FindBy(xpath = ".//a[text()='Men_test']")
    private WebElement menOption_test;

    @FindBy(xpath = "(.//p[text()='Shorts'])[1]")
    private WebElement shortsOption;

    @FindBy(xpath = ".//div[contains(text(),'Jordan Sport')]//following::div[contains(text(),'FIT Mesh Diamond Shorts')]/parent::div/preceding-sibling::div[text()='Just In']")
    private WebElement nikeItem;

    public NikeHomePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectItem() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(6000);
        wait.until(ExpectedConditions.elementToBeClickable(menOption));
        actions.moveToElement(menOption).perform();
        logger.info("Selected mens option");
        Thread.sleep(6000);
        wait.until(ExpectedConditions.elementToBeClickable(shortsOption)).click();
        //shortsOption.click();
        logger.info("selected shorts");
        Thread.sleep(6000);
        actions.scrollToElement(nikeItem).click();
        logger.info("selected item");
        Thread.sleep(6000);
        //menOption_test.getText();
    }

}
