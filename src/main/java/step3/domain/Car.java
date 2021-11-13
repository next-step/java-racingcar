package step3.domain;

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
