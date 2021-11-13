package step3.domain;

import step3.movingstrategy.MovingStrategy;

public class Car {
    private int location = 0;


    public int play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        if (moved) {
            location += 1;
        }
        return location;
    }
}
