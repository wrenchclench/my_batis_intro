package mybatis.model.ibmVisualRec;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassResult {

    @JsonProperty("class")
    String classresultclass;
    Number score;
    String type_hierarchy;

    public Number getScore() {
        return score;
    }

    public void setScore(Number score) {
        this.score = score;
    }

    public String getType_hierarchy() {
        return type_hierarchy;
    }

    public void setType_hierarchy(String type_hierarchy) {
        this.type_hierarchy = type_hierarchy;
    }

    public String getClassresultclass() {
        return classresultclass;
    }

    public void setClassresultclass(String classresultclass) {
        this.classresultclass = classresultclass;
    }
}
