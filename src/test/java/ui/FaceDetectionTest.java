package ui;

import core.model.ImageTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FaceDetectionTest extends BaseTest {

    @DataProvider
    public Object[] images() {
        return new ImageTO[]{
                avengersImageTO,
                elonImageTO,
                arnoldImageTO,
        };
    }

    @BeforeClass
    public void openFaceDetectionTab(){
        steps.openFaceDetectionTab();
    }

    //verify that the proper number of faces can be detected in the image
    @Test(dataProvider = "images")
    public void faceCanBeDetected(ImageTO image) {
        steps.uploadImage(image);
        steps.verifyResultFacesQuantity(image);
    }

    //verify that face can not be detected on the image without face
    @Test
    public void faceCanNotBeDetected() {
        steps.uploadImage(noFaceImageTO);
        steps.verifyResultFacesQuantity(noFaceImageTO);
    }
}
