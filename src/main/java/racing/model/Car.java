package racing.model;

import racing.strategy.MoveStrategy;

public class Car {
    private final Position position;

    private final Name name;

    public Car(String name) {
        this.position = new Position(0);
        this.name = new Name(name);
    }
    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void movable(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.move();
        }
    }
}
