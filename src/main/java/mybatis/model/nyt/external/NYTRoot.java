package mybatis.model.nyt.external;

public class NYTRoot {

    String status;
    String copyright;
    NYTResponse response;

    public NYTRoot(String status, String copyright, NYTResponse response) {
        this.status = status;
        this.copyright = copyright;
        this.response = response;
    }
// Empty Constructor
    public NYTRoot() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public NYTResponse getResponse() {
        return response;
    }

    public void setResponse(NYTResponse response) {
        this.response = response;
    }
}
