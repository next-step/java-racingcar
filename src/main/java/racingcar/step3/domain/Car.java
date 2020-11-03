package racingcar.step3.domain;

/**
 * Created : 2020-11-02 오전 8:32
 * Developer : Seo
 */
public class Car {
    private final String name;
    private int distance;

    public Car(String i) {
        this.name = i;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }
}
