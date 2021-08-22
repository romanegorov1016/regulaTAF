package core.utils;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public final class WebElementWrapper {

  private static final int TIMEOUT = 20;
  private static final int POLLING = 100;

  private WebDriver driver;

  private WebDriverWait wait;

  public WebElementWrapper(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, TIMEOUT, POLLING);
  }

  public WebElement findElement(By locator) {
    waitForPageLoaded();
    return driver.findElement(locator);
  }

  public List<WebElement> findElements(By locator) {
    waitForPageLoaded();
    return driver.findElements(locator);
  }

  public void click(By locator) {
    waitForPageLoaded();
    waitForElementToBeClickable(locator);
    log.info(String.format("Clicking on element located: %s", locator));
    driver.findElement(locator).click();
  }

  public void click(WebElement element) {
    waitForPageLoaded();
    waitForElementToBeClickable(element);
    log.info(String.format("Clicking on element %s", element));
    element.click();
  }

  public void jsClick(By locator) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    waitForPageLoaded();
    waitForElementToBeClickable(locator);
    executor.executeScript("arguments[0].click();", driver.findElement(locator));
    log.info(String.format("Clicking on element located: %s", locator));
  }

  public void sendKeys(By locator, String text) {
    waitForPageLoaded();
    waitForElementToExist(locator);
    log.info(String.format("Sending value '%s' to element located: %s", text, locator));
    WebElement element = driver.findElement(locator);
    element.sendKeys(text);
  }

  public void navigateBack() {
    driver.navigate().back();
  }

  private void waitForElementToExist(By locator) {
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  private void waitForElementToAppear(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void waitForElementToDisappear(By locator) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  private void waitForElementToBeClickable(By locator) {
    log.info(String.format("Waiting for element to be clickable by locator '%s'", locator));
    wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  private void waitForElementToBeClickable(WebElement element) {
    log.info(String.format("Waiting for element to be clickable '%s'", element));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  private void waitForPageLoaded() {
    log.info("Waiting for page to be loaded");
    ExpectedCondition<Boolean> pageLoadCondition =
        webDriver -> {
          assert webDriver != null;
          return ((JavascriptExecutor) webDriver)
              .executeScript("return document.readyState")
              .equals("complete");
        };
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(pageLoadCondition);
  }
}
