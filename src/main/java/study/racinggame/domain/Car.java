package study.racinggame.domain;

import study.racinggame.domain.strategy.MoveStrategy;

public class Car {
    private final Position position;
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(int position, String name) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position.increase();
        }
    }
}
