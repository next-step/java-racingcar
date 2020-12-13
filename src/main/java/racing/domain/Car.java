package racing.domain;

public class Car {

    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        distance++;
    }

    public int getMovedDistance() {
        return distance;
    }
}
