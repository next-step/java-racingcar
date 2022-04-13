package racing.domain;

public class Car {
    private final String name;
    private int distance;

    Car() {
        this.name = "";
        this.distance = 0;
    }

    private Car(int distance) {
        this.name = "";
        this.distance = distance;
    }

    public int move(Movable movable) {
        if (movable.isMovable()) {
            return ++distance;
        }
        return distance;
    }

    public int getDistance() {
        return distance;
    }

    public Car newInstance() {
        return new Car(distance);
    }
}
