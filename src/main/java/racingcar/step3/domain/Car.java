package racingcar.step3.domain;

/**
 * Created : 2020-11-02 오전 8:32
 * Developer : Seo
 */
public class Car {
    private int name;
    private int distance;

    public Car(int i) {
        this.name = i;
    }

    public int getName() {
        return this.name;
    }

    public void move() {
        this.distance++;
    }

    public String getDistance() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
