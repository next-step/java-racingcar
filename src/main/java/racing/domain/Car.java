package racing.domain;

public class Car {
    private final String name;
    private int distance;

    Car(String name) {
        this(name, 0);
    }

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    Car move(Movable movable) {
        if (movable.isMovable()) {
            return new Car(name, ++distance);
        }
        return new Car(name, distance);
    }

    int getGreaterDistance(int distance) {
        return this.distance > distance ? this.distance : distance;
    }

    Car getCarMovingMaxDistance(int maxDistance) {
        return this.distance == maxDistance ? this : null;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
