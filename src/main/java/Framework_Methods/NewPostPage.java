package Framework_Methods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class NewPostPage {
    private final WebDriver driver;

    @FindBy(css = "h3.text-center")
    private WebElement title;

    @FindBy(css = "img.image-preview")
    private WebElement imageContainer;

    @FindBy(id = "choose-file")
    private WebElement browseButton;

    @FindBy(css = "input.input-lg")
    private WebElement uploadImageBoxName;

    @FindBy(css = ".file[type='file']")
    private WebElement imageName;

    @FindBy(name = "caption")
    private WebElement postCaption;

    @FindBy(className = "custom-control-label")
    private WebElement postStatusLabel;

    @FindBy(id = "create-post")
    private WebElement createPostButton;


    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/posts/create";

    public NewPostPage(WebDriver driver) {
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

    public String getTitleElementText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    public void clickBrowseButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(browseButton));
        browseButton.click();
    }

    public void enterPostCaption(String postCation){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(postCaption));
        postCaption.sendKeys(postCation);
    }

    public void changePostStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(postStatusLabel));
        postStatusLabel.click();
    }

    public void createPost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(createPostButton));
        createPostButton.click();
    }

    public void uploadImage(File file){
        imageName.sendKeys(file.getAbsolutePath());
    }

    public boolean isImageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
         return wait.until(ExpectedConditions.visibilityOf(imageContainer)).isDisplayed();
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    public String getImageName(){
        return uploadImageBoxName.getAttribute("placeholder");
    }

}