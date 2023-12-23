package TC_05;

import Framework_Methods.Header;
import Framework_Methods.LoginPage;
import Framework_Methods.ProfilePage;
import _TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.File;

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

        //Verify there are followers
        Assert.assertNotEquals(profilePage.getFollowersCount(), "0", "Nobody follows the user yet");

        //Verify current user follows other users
        Assert.assertNotEquals(profilePage.getFollowingCount(), "0", "Current user does not follow other user yet");

        //Verify current user follows other users
        Assert.assertNotEquals(profilePage.getDescription(), "", "Current user does not have description yet");

        //Verify there are posts
        Assert.assertNotEquals(profilePage.getPostsCount(), "0", "There is no posts yet");

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
