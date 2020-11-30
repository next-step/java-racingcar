package race.model;

import race.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public MoveStrategy moveStrategy;
    public List<Boolean> history;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.history = new ArrayList<>();
    }

    public void move() {
        history.add(moveStrategy.isMovable());
    }

    public int getPositionInRace(int runCount) {
        int position = 0;

        for (int i = 0; i < runCount; i++) {
            position = increasePosition(history.get(i), position);
        }
        return position;
    }

    private int increasePosition(boolean wasMoved, int currentPosition) {
        if (wasMoved) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
