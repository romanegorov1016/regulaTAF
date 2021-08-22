package core.utils;

import core.model.ImageTO;
import lombok.extern.log4j.Log4j2;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log4j2
public class ImageTOHelper {
    private static final String ELON_IMAGE_PATH = "src/main/resources/testData/images/elon.jpg";
    private static final String AVENGERS_IMAGE_PATH = "src/main/resources/testData/images/avengers.jpg";
    private static final String ARNOLD_IMAGE_PATH = "src/main/resources/testData/images/arnold.jpg";
    private static final String ALIEN_IMAGE_PATH = "src/main/resources/testData/images/alien.jpg";

    public static ImageTO getElonImageTO() {
        Path path = Paths.get(ELON_IMAGE_PATH);
        return new ImageTO(path.toAbsolutePath().toString(), 2);
    }

    public static ImageTO getAvengersImageTO() {
        Path path = Paths.get(AVENGERS_IMAGE_PATH);
        return new ImageTO(path.toAbsolutePath().toString(), 5);
    }

    public static ImageTO getArnoldImageTO() {
        Path path = Paths.get(ARNOLD_IMAGE_PATH);
        return new ImageTO(path.toAbsolutePath().toString(), 1);
    }

    public static ImageTO getNoFaceImageTO(){
        Path path = Paths.get(ALIEN_IMAGE_PATH);
        return new ImageTO(path.toAbsolutePath().toString(), 0);
    }

}
