package step3;

public class Car {

    private final long id;
    private int distance;

    public Car(long id) {
        this.id = id;
        this.distance = 0;
    }

    public int move() {
        return ++distance;
    }

    public int getDistance() {
        return distance;
    }
}
