package step3;

import step3.movingstrategy.MovingStrategy;

public class Car {
    public int location = 0;

    public void play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        if (moved) {
            location++;
        }
    }
}
