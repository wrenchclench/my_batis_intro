package mybatis.model.fc;

import mybatis.model.ibmVisualRec.ClassifiedImage;

public class FullContactWatsonSummary {

    int id;
    String fullName;
    String city;
    String country;
    int images_processed;
    ClassifiedImage[] images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImages_processed() {
        return images_processed;
    }

    public void setImages_processed(int images_processed) {
        this.images_processed = images_processed;
    }

    public ClassifiedImage[] getImages() {
        return images;
    }

    public void setImages(ClassifiedImage[] images) {
        this.images = images;
    }
}
