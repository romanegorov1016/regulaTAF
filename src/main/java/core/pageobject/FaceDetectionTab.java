package core.pageobject;

import core.model.ImageTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FaceDetectionTab extends StartPage{

    public FaceDetectionTab(WebDriver driver){
        super(driver);
    }

    private final By uploadImageInput = By.xpath("//input[@id = 'drag_and_drop-api']");
    private final By resultImage = By.xpath("//div[@class = 'results__detection']//img");

    public void uploadImage(ImageTO image){
      webElementWrapper.sendKeys(uploadImageInput, image.getImagePath());
    }

    public int getResultFacesQuantity(){
      List<WebElement> resultImages = webElementWrapper.findElements(resultImage);
      return resultImages.size();
    }
}
