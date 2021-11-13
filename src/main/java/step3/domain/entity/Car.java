package step3.domain.entity;

import step3.domain.value.Location;
import step3.movingstrategy.MovingStrategy;

public class Car {
    private Location location = new Location(0);

    public Location play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        if (moved) {
            location = location.forward();
        }
        return location;
    }
}
