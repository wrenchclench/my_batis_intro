package mybatis.model.ibmVisualRec;

public class ClassifierResult {

    String name;
    String classifierId;
    ClassResult[] classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassifierId() {
        return classifierId;
    }

    public void setClassifierId(String classifierId) {
        this.classifierId = classifierId;
    }

    public ClassResult[] getClasses() {
        return classes;
    }

    public void setClasses(ClassResult[] classes) {
        this.classes = classes;
    }
}
