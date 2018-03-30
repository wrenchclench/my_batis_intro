package mybatis.model.ibmVisualRec;

public class ClassifiedImages {

    int custom_classes;
    int images_processed;
    ClassifiedImage[] images;
    WarningInfo[] warnings;

    public int getCustom_classes() {
        return custom_classes;
    }

    public void setCustom_classes(int custom_classes) {
        this.custom_classes = custom_classes;
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

    public WarningInfo[] getWarnings() {
        return warnings;
    }

    public void setWarnings(WarningInfo[] warnings) {
        this.warnings = warnings;
    }
}
