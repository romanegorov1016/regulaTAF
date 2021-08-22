package core.service;

import core.model.Browser;
import core.utils.PropertyHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Log4j2
public final class DriverFactory {

  private DriverFactory() {
    throw new IllegalStateException("Utility class");
  }

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver(Browser browser) {
    if (browser == Browser.CHROME) {
      driver.set(getChromeDriver());
    } else {
      throw new IllegalStateException("Unexpected value: " + browser);
    }
    return driver.get();
  }

  private static WebDriver getChromeDriver() {
    System.setProperty(
        PropertyHelper.getPropertyByKey("regula.driver.chrome"), System.getenv("CHROME_DRIVER_HOME"));
    return new ChromeDriver();
  }
}
