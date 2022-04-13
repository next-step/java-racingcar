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

    Car move(Movable movable) {
        if (movable.isMovable()) {
            return new Car(++distance);
        }
        return new Car(distance);
    }

    public int getDistance() {
        return distance;
    }
}
