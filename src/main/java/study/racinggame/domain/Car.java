package study.racinggame.domain;

import study.racinggame.domain.strategy.MoveStrategy;
import study.racinggame.domain.strategy.RandomMoveStrategy;

public class Car {
    private int position;
    private Name name;

    private final MoveStrategy moveStrategy;

    public Car(String name) {
        this.name = new Name(name);
        this.moveStrategy = new RandomMoveStrategy();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }
}
