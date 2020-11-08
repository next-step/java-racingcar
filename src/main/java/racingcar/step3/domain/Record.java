package racingcar.step3.domain;

/**
 * Created : 2020-11-09 오전 8:25
 * Developer : Seo
 */
public class Record {
    private int distance;

    public void setDistance() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}
