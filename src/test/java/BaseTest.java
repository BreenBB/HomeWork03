import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    public WebDriver getDriver() {
        return driver;
    }
    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public SearchResultsPage getSearchResultsPage() { return new SearchResultsPage(getDriver()); }
    public LoginPage getLoginPage() {
        return new LoginPage(getDriver());
    }
    public ElectronicsCatalogPage getElectronicsPage() {
        return new ElectronicsCatalogPage(getDriver());
    }
    public ComputerCatalogPage getComputerCatalogPage() {
        return new ComputerCatalogPage(getDriver());
    }

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
