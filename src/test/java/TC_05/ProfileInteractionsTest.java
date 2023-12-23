package TC_05;

import Framework_Methods.Header;
import Framework_Methods.HomePage;
import Framework_Methods.LoginPage;
import Framework_Methods.ProfilePage;
import TC_01.LoginTest;
import _TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProfileInteractionsTest extends TestBase {
    private WebDriver driver;

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        String email = "BlaBlaBlo@abv.bg";
        String password = "111111A";
        String name = "BlaBlaBlo";
        return new Object[][]{
                {email, password, name},
        };
    }

    @Test(dataProvider = "getUsers")
    public void testProfileInteractions(String email, String password, String name) {

        //Login Class
        LoginPage loginPage = new LoginPage(super.getDriver());

        //Login
        loginPage.login(email, password);

        //Header Class
        Header headerMenu = new Header(super.getDriver());

        //Click on Profile
        headerMenu.clickProfile();

        //Create Profile Class
        ProfilePage profilePage = new ProfilePage(super.getDriver());
        profilePage.isUrlLoaded();

        //Verify Logged in user text matches data provider
        Assert.assertEquals(profilePage.getUsername(), name, "Username does not match");

        //Verify there are posts
        Assert.assertEquals(profilePage.getPostsCount(), "0", "There is no posts yet");

        //Verify there are followers
        Assert.assertEquals(profilePage.getFollowersCount(), "0", "Nobody follows the user yet");

        //Verify current user follows other users
        Assert.assertEquals(profilePage.getFollowingCount(), "0", "Current user does not follow other user yet");

        //Verify current user follows other users
        Assert.assertEquals(profilePage.getDescription(), "", "Current user does not have description yet");

        //Open all posts
        profilePage.clickAllPostsLink();

        //Open first post
        profilePage.openFirstPost();

        //Make the first post private
        profilePage.makePostPrivate();

        //Click on delete post
        profilePage.clickDeleteLink();

        //Click on refuse deletion button, which actually deletes the post
        profilePage.refuseDeletion();

    }
}
