package core.pageobject;

import core.utils.WebElementWrapper;
import org.openqa.selenium.WebDriver;

abstract class BasePage {

  WebElementWrapper webElementWrapper;

  BasePage(WebDriver driver) {
    this.webElementWrapper = new WebElementWrapper(driver);
  }

  public void navigateBack() {
    webElementWrapper.navigateBack();
  }
}
