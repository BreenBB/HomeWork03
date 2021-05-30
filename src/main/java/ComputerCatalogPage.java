import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;
import java.util.List;

public class ComputerCatalogPage extends BasePage {

    @FindBy(xpath = "//label[@for='fltr-proizvoditel-asus']/a[contains(@href, 'proizvoditel--asus')]")
    private WebElement asusBrandButton;

    @FindBy(xpath = "//label[@for='fltr-proizvoditel-asus']/a[contains(@href, 'proizvoditel--asus')]")
    private List<WebElement> asusBrandElements;

    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    private List<WebElement> sortSelectionElement;

    @FindBy(xpath = "//ul[@class='select2-results__options']//li[contains(text(),'По возрастанию')]")
    private WebElement ascendingOrderButton;

    @FindBy(xpath = "//div[@class='prod-cart__prise-new']")
    private List<WebElement> productPriceElements;

    public void clickOnAsusBrandButton() {
        asusBrandButton.click();
    }

    public int getAsusBrandElementsCount() {
        return getAsusBrandElementList().size();
    }
    public List<WebElement> getAsusBrandElementList() {
        return asusBrandElements;
    }

    public int getProductPriceElementCount() {
        return getProductPriceElementList().size();
    }
    public List<WebElement> getProductPriceElementList() {
        return productPriceElements;
    }
    public int getPriceFromPriceElementCount(int i) {
        String price = productPriceElements.get(i).getText();
        return Integer.parseInt(price.replaceAll("[^0-9.]", ""));
    }

    public void clickOnSortSelectionElement(int i) {
        sortSelectionElement.get(i).click();
    }
    public WebElement getSortSelectionElement(int i) {
        return sortSelectionElement.get(i);
    }
    public int getSortSelectionElementCount() {
        return getSortSelectionElementList().size();
    }
    public List<WebElement> getSortSelectionElementList() {
        return sortSelectionElement;
    }

    public WebElement getAscendingOrderButton() {
        return ascendingOrderButton;
    }
    public void clickOnAscendingOrderButton() {
        ascendingOrderButton.click();
    }

    public ComputerCatalogPage(WebDriver driver) {
        super(driver);
    }
}
