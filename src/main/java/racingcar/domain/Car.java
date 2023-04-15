package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private int position = 0;
    private Name name;

    public Car(final String name) {
        this.name = new Name(name);
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public Name getName() {
        return name;
    }
}
