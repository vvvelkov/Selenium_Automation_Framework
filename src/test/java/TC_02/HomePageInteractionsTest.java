package TC_02;

import Framework_Methods.Header;
import Framework_Methods.HomePage;
import Framework_Methods.LoginPage;
import _TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class HomePageInteractionsTest extends TestBase {

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
    public void testHomePage(String email, String password) {

        //Login Class
        LoginPage loginPage = new LoginPage(super.getDriver());

        //Login
        loginPage.login(email, password);

        // Home Page Class
        HomePage homePage = new HomePage(super.getDriver());

        //Like the first loaded post
        homePage.likeFirstPost();

        //Thumbs down first loaded post
        homePage.thumbsDownFirstPost();

        //Follow second user
        homePage.followSecondUser();

        //Get the name of the first user
        String firstUserName = homePage.getFirstUserName();

        //Header Class
        Header headerMenu = new Header(super.getDriver());

        //Add first user's name in search bar
        headerMenu.addUsernameInSearchBar(firstUserName);

        //Open first user's profile page
        headerMenu.clickSmallUserIcon();

    }
}
