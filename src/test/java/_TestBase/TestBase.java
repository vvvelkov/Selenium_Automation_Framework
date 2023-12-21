package _TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {

    public static final String TEST_RESOURCES_DIR = "src/main/resources/";
    public static final String SCREENSHOTS_DIR = TEST_RESOURCES_DIR.concat("screenshots/");

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    protected final void setupTestSuite() throws IOException {
        cleanDirectory(SCREENSHOTS_DIR);
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpMethod() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected final void tearDownTest(ITestResult testResult) {
        takeScreenshot(testResult);
        quitDriver();
    }

    //Cleans files in a directory provided as input parameter
    private void cleanDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);

        Assert.assertTrue(directory.isDirectory(), "Invalid directory!");

        FileUtils.cleanDirectory(directory);
        String[] fileList = directory.list();
        if (fileList != null && fileList.length == 0) {
            System.out.printf("All files are deleted in Directory: %s%n", directoryPath);
        } else {
            System.out.printf("Unable to delete the files in Directory:%s%n", directoryPath);
        }
    }

    // Takes screenshot of the currently opened browser page
    private void takeScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String testName = testResult.getName();
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                System.out.println("Unable to create a screenshot file: " + e.getMessage());
            }
        }

    }

    private void quitDriver() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public void waitAndClick(By identifier){
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 1 second.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(identifier));
        elem.click();
    }

    public void waitAndClickElement(WebElement element){
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 1 second.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(element));
        elem.click();
    }

    private String generateRandomEmail(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }
}