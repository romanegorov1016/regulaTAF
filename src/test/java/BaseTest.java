import core.model.Browser;
import core.model.ImageTO;
import core.service.DriverFactory;
import core.steps.Steps;
import core.utils.ImageTOHelper;
import core.utils.PropertyHelper;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

  private static WebDriver driver;
  static Steps steps;
  protected static ImageTO elonImageTO;
  protected static ImageTO avengersImageTO;
  protected static ImageTO arnoldImageTO;
  protected static ImageTO noFaceImageTO;

  @BeforeClass
  static void setup() {
    webDriverSetup();
    imageTOSetup();
    steps = new Steps(driver);
  }

  @AfterClass
  static void quitBrowser() {
    driver.close();
  }

  private static void webDriverSetup() {
    driver = DriverFactory.getDriver(Browser.CHROME);
    driver.get(PropertyHelper.getPropertyByKey("regula.startPage.url"));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  private static void imageTOSetup(){
    elonImageTO = ImageTOHelper.getElonImageTO();
    avengersImageTO = ImageTOHelper.getAvengersImageTO();
    arnoldImageTO = ImageTOHelper.getArnoldImageTO();
    noFaceImageTO = ImageTOHelper.getNoFaceImageTO();
  }
}
