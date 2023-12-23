package Framework_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    private final WebDriver driver;

    @FindBy(css = ".profile-edit-btn")
    private WebElement followButton;

    @FindBy(css = ".btn-all")
    private WebElement allPostsButton;

    @FindBy(css = ".app-post:first-of-type")
    private WebElement firstPost;

    @FindBy(css = ".post-date")
    private WebElement postDate;

    @FindBy(css = "i.like")
    private WebElement likeIcon;

    @FindBy(css = "i.liked")
    private WebElement dislikeIcon;

    @FindBy(css = "[formcontrolname = content]")
    private WebElement commentSection;

    @FindBy(css = ".profile-edit-btn")
    private WebElement unfollowButton;

    @FindBy(css = ".post-user")
    private WebElement postUser;

    @FindBy(css = ".btn-all")
    private WebElement allPostsLink;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyUserPageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users"));
    }

    public void clickAllPostsLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(allPostsLink));
        allPostsLink.click();
    }

    public void followUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(followButton));
        followButton.click();
    }

    public void openFirstPost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPost));
        firstPost.click();
    }

    public void verifyPostPageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(postDate));
    }

    public void likePost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(likeIcon));
        likeIcon.click();
    }

    public void dislikePost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(dislikeIcon));
        dislikeIcon.click();
    }

    public void commentPost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(commentSection));
        commentSection.sendKeys("hello");
    }

    public void closePost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(postUser));
        postUser.click();
    }

    public void unfollowUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(unfollowButton));
        unfollowButton.click();
    }

}