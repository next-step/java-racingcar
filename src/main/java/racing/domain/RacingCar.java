package racing.domain;

import racing.domain.move.MoveStrategy;

public class RacingCar {
    private static final int MOVE_DISTANCE = 1;
    private final MoveStrategy moveStrategy;
    private final Name name;
    private Position position;

    public RacingCar(String name, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = new Position();
        this.moveStrategy = moveStrategy;
    }

    public Name name() {
        return name;
    }

    public Position position() {
        return position;
    }

    public void move() {
        if (moveStrategy.move()) {
            position = position.increase(MOVE_DISTANCE);
        }
    }
}
