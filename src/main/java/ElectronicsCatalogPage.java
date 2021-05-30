import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsCatalogPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'brand-box__title')]//a[contains(@href, 'gotovyie-pk')]")
    private WebElement computerCatalogButton;

    public void clickOnComputerCatalogButton() {
        computerCatalogButton.click();
    }

    public ElectronicsCatalogPage(WebDriver driver) {
        super(driver);
    }
}
