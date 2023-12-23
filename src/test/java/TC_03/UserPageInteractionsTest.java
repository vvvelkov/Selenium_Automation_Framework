package TC_03;

import Framework_Methods.HomePage;
import Framework_Methods.LoginPage;
import Framework_Methods.UserPage;
import _TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class UserPageInteractionsTest extends TestBase {

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
    public void testUserPage(String email, String password) {

        //Login Class
        LoginPage loginPage = new LoginPage(super.getDriver());

        //Login
        loginPage.login(email, password);

        //Home Page Class
        HomePage homePage = new HomePage(super.getDriver());

        //Click on the first user appeared to redirect to their profile page
        homePage.clickUser();

        //Verify we are on the user's page
        UserPage userPage = new UserPage(super.getDriver());
        userPage.verifyUserPageOpened();

        //Follow the user
        userPage.followUser();

        //Open all posts
        userPage.clickAllPostsLink();

        //Open first post
        userPage.openFirstPost();

        //Verify that we are on the post page
        userPage.verifyPostPageOpened();

        //Like the post
        userPage.likePost();

        //Dislike the post
        userPage.dislikePost();

        //Comment hello on the post
        userPage.commentPost();

        //Close post
        userPage.closePost();

        //Unfollow the user
        userPage.unfollowUser();
    }
}
