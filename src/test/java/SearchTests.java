import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String SEARCH_KEYWORD = "айфон 11";
    private String RESULT_TEXT_CHECK = "iPhone 11";

    @Test(priority = 1)
    public void checkThatSearchFindResultUsingRussianWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(RESULT_TEXT_CHECK));
        }
    }
}
