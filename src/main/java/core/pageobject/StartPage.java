package core.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {

  public StartPage(WebDriver driver) {
    super(driver);
  }

  private static final String TAB_PATTERN = "//li[(contains(@class, 'tabs__tab')) and(contains(text(), '%s'))]";

  private static final String FACE_DETECTION_TAB_NAME= "Face detection";

  private static final By faceDetectionTab = By.xpath(String.format(TAB_PATTERN, FACE_DETECTION_TAB_NAME));

  public void openFaceDetectionTab() {
      webElementWrapper.click(faceDetectionTab);
  }
}
