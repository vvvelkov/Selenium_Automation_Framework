package Framework_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;

    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;

    @FindBy(className = "fa-sign-out-alt")
    private WebElement signOutLink;

    @FindBy(id = "search-bar")
    private WebElement searchBar;

    @FindBy(xpath = "(//a[@class=\"post-user\"])[1]")
    private WebElement smallUserIcon;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }

    public void clickSmallUserIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(smallUserIcon));
        smallUserIcon.click();
    }

    public void addUsernameInSearchBar(String firstUserName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.click();
        searchBar.sendKeys(firstUserName);
    }

    public void clickNewPostLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newPostLink));
        newPostLink.click();
    }

    public void clickSignOutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink));
        signOutLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }
}