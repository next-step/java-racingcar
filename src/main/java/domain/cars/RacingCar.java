package domain.cars;

import static domain.cars.Distance.DEFAULT_DISTANCE;
import static domain.cars.Name.DEFAULT_NAME;

public class RacingCar {

    private Name name;
    private Distance distance;

    RacingCar() {
        this(DEFAULT_NAME, DEFAULT_DISTANCE);
    }

    public RacingCar(String name) {
        this(name, DEFAULT_DISTANCE);
    }

    public RacingCar(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void moveOrStop(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            distance.move();
        }
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public boolean isSameDistance(int maxDistance) {
        return distance.isSameDistance(maxDistance);
    }

    public String getName() {
        return name.getName();
    }
}
