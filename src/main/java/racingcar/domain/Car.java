package racingcar.domain;

public class Car {

    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String name() { return name; }

    public int distance() { return distance; }

    public void run() {
        this.distance++;
    }
}
