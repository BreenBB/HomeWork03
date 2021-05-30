import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    public void checkNegativeTestLogin() {
        getHomePage().clickOnLoginButton();
        getLoginPage().implicitWait(30);
        getLoginPage().enterLogin("example@mail.com");
        getLoginPage().enterPassword("password");
        getLoginPage().clickOnSubmitButtonWithWait(30);
        getLoginPage().implicitWait(30);
        assertEquals(getLoginPage().getNegativeMessageText(), "Неверные данные авторизации.");
    }
}
