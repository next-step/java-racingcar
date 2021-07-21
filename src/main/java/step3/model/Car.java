package step3.model;

import step3.App;
import step3.move.MovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final List<Integer> moveRecord = new ArrayList<>(Collections.singletonList(0));
    private final MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void moveIf(int num) {
        validateNumber(num);
        moveRecord.add(now() + movableStrategy.move(num));
    }

    public int now() {
        return moveRecord.get(moveRecord.size() - 1);
    }

    private void validateNumber(int num) {
        if (num > App.RANGE_MAX || num < App.RANGE_MIN) throw new IndexOutOfBoundsException();
    }

    public int getPointOfTime(int time) {
        return moveRecord.get(time);
    }
}
