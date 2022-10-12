package racing;

import java.util.Objects;

public class Car {
    private final CarName name;
    private CarDistance distance;

    public Car(String name) {
        this(name, 0);
    }

    // only for test
    Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = new CarDistance(distance);
    }

    public void tryMove(CarMovingStrategy strategy) {
        if (strategy.shouldMove()) {
            distance = distance.add(1);
        }
    }

    public CarName getName() {
        return name;
    }

    public CarDistance getDistance() {
        return distance;
    }

    public boolean hasDistance(CarDistance other) {
        return Objects.equals(distance, other);
    }
}
