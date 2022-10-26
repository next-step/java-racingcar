package race.domian;

import race.strategy.MoveStrategy;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            ++position;
        }
    }

    public int getPosition() {
        return position;
    }
}
