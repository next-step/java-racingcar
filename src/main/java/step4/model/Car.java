package step4.model;

import step4.move.MovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final List<Integer> moveRecord = new ArrayList<>(Collections.singletonList(0));
    private final MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        moveRecord.add(now() + movableStrategy.move());
    }

    public int now() {
        return moveRecord.get(moveRecord.size() - 1);
    }

    public int getPointOfTime(int time) {
        return moveRecord.get(time);
    }
}
