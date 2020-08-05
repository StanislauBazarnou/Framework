package framework.page;

import framework.model.CalculatorForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {
    private String totalCostOnPage;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTotalCostOnPage() {
        return totalCostOnPage;
    }

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;
    @FindBy (id = "myFrame")
    WebElement secondFrame;
    @FindBy (xpath = "//*[@id='mainForm']//div[@title='Compute Engine']")
    WebElement computeEngineButton;

    @FindBy (id = "input_61")
    WebElement numberOfInstancesField;

    @FindBy (xpath = "(//md-checkbox[@aria-label='Add GPUs' and @role='checkbox'])[1]")
    WebElement addGpuCheckbox;
    @FindBy (xpath = "//form[@name='ComputeEngineForm']//button[@aria-label = 'Add to Estimate']")
    WebElement buttonAddToEstimate;

    @FindBy (xpath = "//*[@id='resultBlock']//h2[@class='md-title']")
    WebElement totalEstimatedCost;

    public CalculatorPage clickComputerEngineButton() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        waitVisibilityOf(computeEngineButton);
        clickThroughJS(computeEngineButton);
        return this;
    }

    public EstimatePage fillRequiredData(CalculatorForm calculatorForm) {
        fillNumberOfInstances(calculatorForm.getNumberOfInstances());
        specifyOptionFromDropdownList(calculatorForm.getOperatingSystemDropdown(), calculatorForm.getOperatingSystem());
        specifyOptionFromDropdownList(calculatorForm.getMachineClassDropdown(), calculatorForm.getMachineClass());
        specifyOptionFromDropdownList(calculatorForm.getMachineTypeDropdown(), calculatorForm.getMachineType());
        clickCheckbox(addGpuCheckbox);
        specifyOptionFromDropdownList(calculatorForm.getNumberOfGpusDropdown(), calculatorForm.getNumberOfGpus());
        specifyOptionFromDropdownList(calculatorForm.getGpuTypeDropdown(), calculatorForm.getGpuType());
        specifyOptionFromDropdownList(calculatorForm.getLocalSsdDropdown(), calculatorForm.getLocalSsd());
        specifyOptionFromDropdownList(calculatorForm.getDatacenterLocationDropdown(), calculatorForm.getDatacenterLocation());
        specifyOptionFromDropdownList(calculatorForm.getCommittedUsageDropdown(), calculatorForm.getCommittedUsage());
        clickButton(buttonAddToEstimate);
        waitVisibilityOf(totalEstimatedCost);
        totalCostOnPage = totalEstimatedCost.getText();
        return new EstimatePage(driver);
    }

    public CalculatorPage fillNumberOfInstances(String number) {
        numberOfInstancesField.sendKeys(number);
        return this;
    }

    public CalculatorPage clickCheckbox(WebElement checkbox) {
        waitVisibilityOf(checkbox);
        clickThroughJS(checkbox);
        return this;
    }

    public CalculatorPage clickButton(WebElement button) {
        waitVisibilityOf(button);
        clickThroughJS(button);
        return this;
    }

    public void waitVisibilityOf(WebElement element){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickThroughJS(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void specifyOptionFromDropdownList(String dropdownList, String option) {
        String dropdownXpath = String.format("//label[text()='%s']/..//md-select", dropdownList);
        WebElement specifiedDropdown = driver.findElement(By.xpath(dropdownXpath));
        waitVisibilityOf(specifiedDropdown);
        clickThroughJS(specifiedDropdown);

        String ariaOwns = specifiedDropdown.getAttribute("aria-owns");

        String xpath = String.format("//*[@id='%s']//div[contains(text(), '%s')]", ariaOwns, option);
        WebElement specifiedOption = driver.findElement(By.xpath(xpath));
        waitVisibilityOf(specifiedOption);
        clickThroughJS(specifiedOption);
    }
}
