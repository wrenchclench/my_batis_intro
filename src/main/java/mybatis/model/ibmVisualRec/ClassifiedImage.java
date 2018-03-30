package mybatis.model.ibmVisualRec;


public class ClassifiedImage {

    String source_url;
    String resolved_url;
    String image;
    ErrorInfo error;
    ClassifierResult[] classifiers;

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getResolved_url() {
        return resolved_url;
    }

    public void setResolved_url(String resolved_url) {
        this.resolved_url = resolved_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ErrorInfo getError() {
        return error;
    }

    public void setError(ErrorInfo error) {
        this.error = error;
    }

    public ClassifierResult[] getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(ClassifierResult[] classifiers) {
        this.classifiers = classifiers;
    }
}
