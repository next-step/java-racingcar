package racingcar.business;

public class Car {

    private String name;
    private int totalDistance = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        this.totalDistance++;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }
}
