package racingcar.model;

import racingcar.module.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Car implements Cloneable {
    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
