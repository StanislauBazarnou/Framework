package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EstimatePage extends AbstractPage {
    private String email;
    private final Logger logger = LogManager.getRootLogger();

    public EstimatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EstimatePage(WebDriver driver, String email) {
        super(driver);
        this.email = email;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='email_quote']")
    WebElement emailEstimateButton;

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrameEmail;

    @FindBy (xpath = "//*[@id='myFrame']")
    WebElement secondFrameEmail;

    @FindBy (xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement emailField;

    @FindBy (xpath = "//button[@aria-label='Send Email']")
    WebElement emailSendButton;

    @FindBy(xpath = "//div[@class='md-list-item-text']")
    WebElement totalCostField;

    public TemporaryEmailPage clickEmailEstimateButton() {
        waitVisibilityOf(emailEstimateButton);
        clickThroughJS(emailEstimateButton);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> browserPages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(1));
        logger.info("Email Estimate Button is clicked");
        return new TemporaryEmailPage(driver);
    }

    public TemporaryEmailPage addEmail() {
        driver.switchTo().frame(firstFrameEmail).switchTo().frame(secondFrameEmail);
        waitVisibilityOf(emailField);
        emailField.sendKeys(email);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(emailSendButton));
        clickThroughJS(emailSendButton);
        ArrayList<String> browserPages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(1));
        logger.info("Email address is add to form");
        return new TemporaryEmailPage(driver);
    }

    public void waitVisibilityOf(WebElement element){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickThroughJS(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String findTotalCost() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(totalCostField));
        logger.info("Final cost is calculated");
        return totalCostField.getText();
    }
}
