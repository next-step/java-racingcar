package step5.model;

import step5.move.MovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final String name;
    private final List<Integer> moveRecord = new ArrayList<>(Collections.singletonList(0));

    public Car(String name) {
        this.name = name;
    }

    public void move(MovableStrategy movableStrategy) {
        moveRecord.add(now() + movableStrategy.move());
    }

    public int now() {
        return moveRecord.get(moveRecord.size() - 1);
    }

    public String nameOf() {
        return name;
    }

    public PointOfCar getPointOfTime(int time) {
        return new PointOfCar(name, moveRecord.get(time));
    }
}
