package mybatis.model.nyt.external;

public class NYTMeta {

    int hits;
    int time;
    int offset;

    public NYTMeta(int hits, int time, int offset) {
        this.hits = hits;
        this.time = time;
        this.offset = offset;
    }

    public NYTMeta() {
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
