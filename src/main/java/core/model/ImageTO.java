package core.model;

import java.awt.image.BufferedImage;

public class ImageTO {

    public ImageTO(String imagePath, int personQuantity){
        this.imagePath = imagePath;
        this.personQuantity = personQuantity;
    }

    private String imagePath;
    private int personQuantity;

    public String getImagePath() {
        return imagePath;
    }

    public void setImage(String image) {
        this.imagePath = image;
    }

    public int getPersonQuantity() {
        return personQuantity;
    }

    public void setPersonQuantity(int personQuantity) {
        this.personQuantity = personQuantity;
    }
}
