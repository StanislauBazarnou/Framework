package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='___gcse_0']//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement desiredSearchResult;

    public CalculatorPage selectDesiredSearchResult() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(desiredSearchResult));
        desiredSearchResult.click();
        return new CalculatorPage(driver);
    }
}