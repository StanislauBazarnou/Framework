import framework.page.GoogleCloudPage;
import framework.model.CalculatorForm;
import framework.service.CalculatorFormCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static framework.service.CalculatorFormCreator.TOTAL_ESTIMATED_COST;
import static framework.service.CalculatorFormCreator.withDataFromProperty;
import static org.testng.Assert.assertTrue;

public class SmokeTest extends CommonConditions {

    @Test
    public void estimateComputeEngineRent() {
        CalculatorForm testPage = CalculatorFormCreator.withDataFromProperty();
        String totalCost = new GoogleCloudPage(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillRequiredData(testPage)
                .findTotalCost();
        assertTrue(totalCost.contains(withDataFromProperty().getTotalEstimatedCost()));
    }
}
