package step4.domain;

import step4.domain.strategy.MovingStrategy;

public class Car {

    private static final int MAX_LENGTH = 5;

    private String name;
    private int position;

    public Car(String name) {
        if (isOverLength(name)) this.name = name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean isOverLength(String name) {
        if (name == null || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }


}
