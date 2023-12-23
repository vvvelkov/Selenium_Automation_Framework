package Framework_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProfilePage {
    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement username;

    @FindBy(xpath = "//*[@class=\"profile-stat-count\"]")
    private WebElement postsCount;

    @FindBy(id = "followers")
    private WebElement followersCount;

    @FindBy(id = "following")
    private WebElement followingCount;

    @FindBy(css = "p > strong")
    private WebElement description;

    @FindBy(css = "app-post.col-4:first-of-type")
    private WebElement firstPost;

    @FindBy(css = "div.icons-container > i[class*=\"ng-star-inserted\"]")
    private WebElement lockButton;

    @FindBy(className = "post-user")
    private WebElement postUserLink;

    @FindBy(className = "delete-ask")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[text()=\"Yes\"]")
    private WebElement deleteButtonYes;

    @FindBy(xpath = "//button[text()=\"No\"]")
    private WebElement deleteButtonNo;

    @FindBy(className = "btn-all")
    private WebElement allPostsLink;

    @FindBy(css = ".fa-plus-square")
    private WebElement newPostLink;
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/";

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getDescription(){
        return description.getText();
    }

    public String getFollowersCount(){
        return followersCount.getText();
    }

    public String getFollowingCount(){
        return followingCount.getText();
    }

    public String getPostsCount(){
        return postsCount.getText();
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PAGE_URL));
    }

    public void openFirstPost(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(firstPost.isDisplayed()){
            firstPost.click();
        }
    }

    public void clickDeleteLink(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(postUserLink.isDisplayed()){
            deleteButton.click();
        }
    }

    public void confirmDeletion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonYes));
        deleteButtonYes.click();
    }

    public void refuseDeletion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonNo));
        deleteButtonNo.click();
    }

    public void makePostPrivate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(lockButton));
        lockButton.click();
    }

    public void clickAllPostsLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(allPostsLink));
        allPostsLink.click();
    }

    public void clickNewPostLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(newPostLink));
        newPostLink.click();
    }

}