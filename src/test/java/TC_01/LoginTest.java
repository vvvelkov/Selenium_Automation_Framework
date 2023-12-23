package TC_01;

import Framework_Methods.Header;
import Framework_Methods.HomePage;
import Framework_Methods.LoginPage;
import _TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {
    private WebDriver driver;


    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        String email = "BlaBlaBlo@abv.bg";
        String password = "111111A";
        return new Object[][]{
                {email, password},
        };
    }

    @Test(dataProvider = "getUsers")
    public void testLogin(String user, String password) {


        // Home Page Class
        HomePage homePage = new HomePage(super.getDriver());
        homePage.navigateTo();
        homePage.isUrlLoaded();

        // Header Class
        Header headerMenu = new Header(super.getDriver());
        headerMenu.clickLogin();

        //Login Class
        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.isUrlLoaded();

        // Get Sign in text
        String elemText = loginPage.getSignInElementText();
        Assert.assertEquals(elemText, "Sign in");

        // Fill in username
        loginPage.populateUsername(user);

        //Fill in password
        loginPage.populatePassword(password);

        //Click on Sign in
        loginPage.clickSignIn();

    }
}
