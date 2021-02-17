package selenium.driver;

import constants.Locator;
import cucumber.hooks.GlobalHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.locatores.HomePageLocator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumWebDriver extends GlobalHooks {
    public static void openPage(String seleniumURL) {
        driver.get(seleniumURL);
    }

    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public static List<WebElement> findElements(By by) { return driver.findElements(by);}
    public static void clickOn(By by) {
        findElement(by).click();
    }
    public static void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }
    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    public static String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }
    public static void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    public static void waitVisibilityOfElement(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds /* seconds */);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void scrollToElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findElement(by));
    }
    public static void forceClick(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('" + element.getAttribute("id") + "').click();");
    }
    public static void moveMouseToElement(Locator locator) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(locator.by());
        action.moveToElement(we).build().perform();
    }
    public static boolean switchTab(String tabName){
        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        for (int i = 0; i < tabs2.size(); i++) {
            if (!driver.getTitle().equals(tabName)) {
                driver.switchTo().window(tabs2.get(i));
            }
        }
        return driver.getTitle().equals(tabName);
    }
    protected static void pageLoadingWait(WebDriver driver, int timeOuts) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, timeOuts);
        wait.until(pageLoadCondition);
    }
}

