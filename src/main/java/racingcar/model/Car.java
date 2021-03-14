package racingcar.model;

import racingcar.module.MovingStrategy;

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

    @Override
    public Car clone() {
        Car clone = null;
        try {
            clone = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }
}
