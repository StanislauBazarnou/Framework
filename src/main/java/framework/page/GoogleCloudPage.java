package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String REQUEST_TEXT = "Google Cloud Platform Pricing Calculator";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    WebElement searchButton;

    @FindBy(name = "q")
    WebElement searchInputLine;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPage openHomePage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchButton));
        logger.info(HOMEPAGE_URL + " was opened");
        return this;
    }

    public SearchResultsPage fillInSearchInputLine() {
        searchButton.click();
        searchInputLine.sendKeys(REQUEST_TEXT + Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
