package racing.domain;

public class Car {
    private final String name;
    private int distance;

    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    private Car(String name, int distance) {
        this.name = "";
        this.distance = distance;
    }

    Car move(Movable movable) {
        if (movable.isMovable()) {
            return new Car(name, ++distance);
        }
        return new Car(name, distance);
    }

    public int getDistance() {
        return distance;
    }
}
