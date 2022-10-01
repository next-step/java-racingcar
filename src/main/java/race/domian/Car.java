package race.domian;

import race.strategy.RandomMoveStrategy;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(RandomMoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            ++position;
        }
    }

    public int getPosition() {
        return position;
    }
}
