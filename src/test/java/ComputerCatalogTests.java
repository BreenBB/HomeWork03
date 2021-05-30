import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ComputerCatalogTests extends BaseTest {

    @Test(priority = 1)
    public void checkListDisplaysOnlyAsusComputers() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnElectronicsButton();
        getElectronicsPage().clickOnComputerCatalogButton();
        getComputerCatalogPage().clickOnAsusBrandButton();
        getComputerCatalogPage().waitForPageLoadComplete(30);
        int count = getComputerCatalogPage().getAsusBrandElementsCount();
        for (int i = 0; i < count; i++) {
            assertTrue(getComputerCatalogPage().getAsusBrandElementList().get(i).getAttribute("data-ecomm").contains("Asus"));
        }
    }

    @Test(priority = 2)
    public void checkListSortingIsWorkingCorrectlyAscendingOrder() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnElectronicsButton();
        getElectronicsPage().clickOnComputerCatalogButton();
        int countSortList = getComputerCatalogPage().getSortSelectionElementCount();
        for (int i = 0; i < countSortList; i++) {
            if (getComputerCatalogPage().getSortSelectionElement(i).isDisplayed()) {
                getComputerCatalogPage().clickOnSortSelectionElement(i);
                break;
            }
        }
        getComputerCatalogPage().waitVisibilityOfElement(30, getComputerCatalogPage().getAscendingOrderButton());
        getComputerCatalogPage().clickOnAscendingOrderButton();
        boolean sortedCorrectly = true;
        int countProductList = getComputerCatalogPage().getProductPriceElementCount();
        for (int i = 1; i < countProductList; i++) {
            if (getComputerCatalogPage().getPriceFromPriceElementCount(i-1)>getComputerCatalogPage().getPriceFromPriceElementCount(i)){
                sortedCorrectly=false;
                break;
            }
        }
        assertTrue(sortedCorrectly);
    }
}
