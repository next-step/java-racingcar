package racing.car;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int MIN_MOVEMENT_DISTANCE = 4;

    private Location location;

    public Car() {
        this.location = Location.EMPTY;
    }

    public Location getLocation() {
        return location;
    }

    public void move(Location distance) {
        if (Objects.isNull(distance) || distance.getValue() < MIN_MOVEMENT_DISTANCE)
            return;
        this.location = location.add(distance);
    }
}
