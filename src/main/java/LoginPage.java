import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='container ']//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//div[@class='container ']//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='container ']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='col-xs-12 js_message']")
    private WebElement negativeMessageField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(final String keyword) {
        loginField.sendKeys(keyword, Keys.ENTER);
    }
    public void enterPassword(final String keyword) {
        passwordField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnSubmitButtonWithWait(long timeToWait) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getNegativeMessageText() {
        return negativeMessageField.getText();
    }
}
