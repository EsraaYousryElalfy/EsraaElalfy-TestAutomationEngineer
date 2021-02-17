package selenium.driver;

import constants.Locator;
import cucumber.hooks.GlobalHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static selenium.locatores.HomePageLocator.Customers_List;

public class SeleniumWebDriver extends GlobalHooks {
    private static final Integer NUM_RETRYS = 3;

    public static void openPage(String seleniumURL) {
        driver.get(seleniumURL);
    }

    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public static void clickOn(By by) {
        findElement(by).click();
    }

    public static void clickOn(WebElement element) {
        element.click();
    }


    public static void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public static void sendKeysAndClear(By by, String text) {
        findElement(by).clear();
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

    public static void waitInVisibilityOfElement(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds /* seconds */);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void scrollToElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findElement(by));
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void forceClick(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('" + element.getAttribute("id") + "').click();");
    }

    public static void forceClick(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('" + element.getAttribute("id") + "').click();");
    }

    public static void moveMouseToElement(Locator locator) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(locator.by());
        action.moveToElement(we).build().perform();
    }

    public static boolean switchTab(String tabName) {
        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        for (int i = 0; i < tabs2.size(); i++) {
            if (!driver.getTitle().equals(tabName)) {
                driver.switchTo().window(tabs2.get(i));
            }
        }
        return driver.getTitle().equals(tabName);
    }

    public static void selectFromListByValue(By by, String option) {
        Select select = new Select(findElement(by));
        select.selectByVisibleText(option);
    }

    public static String selectRandomlyFromDropList(By by) {
        boolean staleElement = true;
        int numberTries = 0;
        String selectedOption = "";
        do {
            try {
                Random rand = new Random();
                List<WebElement> options = driver.findElements(by);
                int selectOption = rand.nextInt(options.size());
                selectedOption = options.get(selectOption).getText().trim();
                scrollToElement(options.get(selectOption));
                options.get(selectOption).click();
                staleElement = false;
            } catch (StaleElementReferenceException ex) {
                if (numberTries == NUM_RETRYS) {
                    throw ex;
                }
            }
        } while (staleElement);
        return selectedOption;
    }
}
