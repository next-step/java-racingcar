package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class Car {

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

}
