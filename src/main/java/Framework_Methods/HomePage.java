package Framework_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    @FindBy(xpath = "(//a[@class=\"post-user\"])[1]")
    private WebElement firstUserButton;

    @FindBy(xpath = "(//i[contains(@class, 'fa-heart')])[1]")
    private WebElement firstPostLikeButton;

    @FindBy(xpath = "(//i[contains(@class, 'fa-thumbs-down')])[1]")
    private WebElement firstPostThumbsDownButton;

    @FindBy(xpath = "(//button[contains(@class, \"btn-primary\")])[2]")
    private WebElement secondUserFollowButton;

    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.urlToBe(HomePage.PAGE_URL));
    }

    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }

    public void clickUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstUserButton));
        firstUserButton.click();
    }

    public String getFirstUserName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstUserButton));
        return firstUserButton.getText();
    }

    public void likeFirstPost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPostLikeButton));
        firstPostLikeButton.click();
    }

    public void thumbsDownFirstPost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPostThumbsDownButton));
        firstPostThumbsDownButton.click();
    }

    public void followSecondUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(secondUserFollowButton));
        secondUserFollowButton.click();
    }

}