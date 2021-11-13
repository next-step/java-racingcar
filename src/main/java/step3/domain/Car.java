package step3.domain;

import step3.movingstrategy.MovingStrategy;

public class Car {
    private int location = 0;

    public void play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        if (moved) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }
}
