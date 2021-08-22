package core.steps;

import core.model.ImageTO;
import core.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Steps {

  private final StartPage startPage;
  private final FaceDetectionTab faceDetectionTab;

  public Steps(WebDriver driver) {
    startPage = new StartPage(driver);
    faceDetectionTab = new FaceDetectionTab(driver);
  }

  public void openFaceDetectionTab(){
    startPage.openFaceDetectionTab();
  }

  public void uploadImage(ImageTO image){
    faceDetectionTab.uploadImage(image);
  }

  public void verifyResultFacesQuantity(ImageTO image){
    Assert.assertEquals(faceDetectionTab.getResultFacesQuantity(), image.getPersonQuantity());
  }
}
