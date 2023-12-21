package Framework_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement userNameField;

    @FindBy(className = "h4")
    private WebElement signInFormTitle;

    @FindBy(css = "[formcontrolname = rememberMe]")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void clickLogin(){
        loginLink.click();
    }

    public void populatePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void populateUsername(String username) {
        userNameField.sendKeys(username);
    }

    public String getSignInElementText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
        return signInFormTitle.getText();
    }

    public void enterEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(email);
    }

    public void login(String name, String password) {
        navigateTo();
        isUrlLoaded();
        populateUsername(name);
        populatePassword(password);
        clickRememberMe();
        clickSignIn();
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickRememberMe(){
        rememberMeCheckbox.click();
    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}