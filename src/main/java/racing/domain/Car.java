package racing.domain;

import racing.domain.move.MoveStrategy;

public class Car {
    private static final int MOVE_DISTANCE = 1;
    private final MoveStrategy moveStrategy;
    private final Name name;
    private Position position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String getNameString() {
        return name.getName();
    }

    public int getPositionInt() {
        return position.getPosition();
    }

    public void move() {
        if (moveStrategy.move()) {
            position = position.increase(MOVE_DISTANCE);
        }
    }
}
