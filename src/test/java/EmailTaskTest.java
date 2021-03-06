import framework.model.CalculatorForm;
import framework.page.CalculatorPage;
import framework.page.GoogleCloudPage;
import framework.page.TemporaryEmailPage;
import framework.service.CalculatorFormCreator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static framework.service.CalculatorFormCreator.withDataFromProperty;
import static org.testng.Assert.assertTrue;

public class EmailTaskTest extends CommonConditions {
    private String result;

    public String getResult() {
        return result;
    }

    @Test
    public void compareCostsFromDifferentSources() {
        CalculatorForm allTestPage = CalculatorFormCreator.withDataFromProperty();
        result = new GoogleCloudPage(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillRequiredData(allTestPage)
                .clickEstimateButton()
                .clickEmailEstimateButton()
                .getEmail()
                .addEmail()
                .getCostInLetter();
        assertTrue(getResult().contains(withDataFromProperty().getTotalEstimatedCost()));

        System.out.println(result + " = " + withDataFromProperty().getTotalEstimatedCost());
    }
}
