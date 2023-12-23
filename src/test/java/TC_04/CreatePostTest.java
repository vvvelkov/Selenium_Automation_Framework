package TC_04;

import Framework_Methods.*;
import TC_01.LoginTest;
import _TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.FileAssert;
import org.testng.annotations.*;

import java.io.File;

public class CreatePostTest extends TestBase {
    private WebDriver driver;

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {

        File postImage = new File("src/main/resources/Uploads/First_Post_Image.jpeg");
        String caption = "Hello there. This is my first post!";
        String email = "BlaBlaBlo@abv.bg";
        String password = "111111A";

        return new Object[][]{
                {caption, email, password, postImage},
        };
    }

    @Test(dataProvider = "getUsers")
    public void testNewPost(String caption, String email, String password, File postImage) {

        //Login Class
        LoginPage loginPage = new LoginPage(super.getDriver());

        //Login
        loginPage.login(email, password);

        //Header Class
        Header headerMenu = new Header(super.getDriver());

        //Redirect to New Post Page
        headerMenu.clickNewPostLink();

        NewPostPage newPostPage = new NewPostPage(super.getDriver());

        //Verify we are on New Post Page
        newPostPage.isUrlLoaded();


        //Upload image
        newPostPage.uploadImage(postImage);

        //Check if image is uploaded
        newPostPage.isImageVisible();

        //Verify uploaded image matches the expected image
        Assert.assertEquals(newPostPage.getImageName(), postImage.getName());

        //Add description of the post
        newPostPage.enterPostCaption(caption);

        //Change status of the post
        newPostPage.changePostStatus();

        //Create the post
        newPostPage.createPost();

    }
}
