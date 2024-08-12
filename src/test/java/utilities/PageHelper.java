package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private static Actions actions;

    public PageHelper() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void findElements(WebElement element) {
        element.click();
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void clickElementWithJs(WebElement element) {
        scrollToElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementByLinkText(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));
        clickElement(element);
    }

    public void assertUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    public void assertUrlContains(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }

    public void assertElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed.");
    }

    public void assertElementText(WebElement element, String expectedText) {
        Assert.assertEquals(element.getText(), expectedText);
    }

    public void assertElementTextContains(WebElement element, String expectedText) {
        Assert.assertTrue(element.getText().contains(expectedText));
    }

    public WebElement verifyElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.err.println("An error occurred during the wait: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public WebElement getRandomItemFromList(List<WebElement> elements) {
        Random rnd = new Random();
        return elements.get(rnd.nextInt(elements.size()));
    }

    public void switchLastTab() {
        ArrayList<String> newTb = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
    }

    public void switchToMainTab() {
        ArrayList<String> newTb = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(0));
    }

    public void closeTab() {
        driver.close();
    }

    public static void pageDown() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
}
