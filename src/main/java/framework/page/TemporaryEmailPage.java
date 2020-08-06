package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class TemporaryEmailPage extends AbstractPage{

    public static final String TEMPORARY_MAIL_URL = "https://10minutemail.com";
    public static final By MAIL_LOCATOR = By.xpath("//div[@id='copy_address']");
    public static final By EXPECTED_MAIL_LOCATOR = By.xpath("//*[@id='mail_messages_content']//div[@class = 'small_message_icon_box']");
    public static final By COST_FROM_MAIL_LOCATOR = By.xpath("//*[@id='mobilepadding']/td/h2");
    private final Logger logger = LogManager.getRootLogger();


    public TemporaryEmailPage(WebDriver driver) {
        super(driver);
    }

    public EstimatePage getEmail() {
        driver.get(TEMPORARY_MAIL_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(MAIL_LOCATOR));
        driver.findElement(MAIL_LOCATOR).click();
        String emailStringValue = null;
        try {
            emailStringValue = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> browserPages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(0));
        logger.info("10 minutes email address is copied to clipboard");
        return new EstimatePage(driver, emailStringValue);
    }

    public String getCostInLetter() {
        WebElement expectedMail = new WebDriverWait(driver, 180)
                .until(ExpectedConditions.elementToBeClickable(EXPECTED_MAIL_LOCATOR));
        expectedMail.click();
        WebElement costFromMail = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(COST_FROM_MAIL_LOCATOR));
        String costInLetter = costFromMail.getText();
        String[] array = costInLetter.split(":");
        logger.info("Received a message with the cost");
        return array[1].trim();
    }
}
