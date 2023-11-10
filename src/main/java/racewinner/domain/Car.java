package racewinner.domain;

import racewinner.domain.strategy.MoveStrategy;

public class Car {
    private final Name name;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this(name, new Position(0), moveStrategy);
    }
    public Car(final String name, final Position position, final MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position.move();
        }
    }

    public Position currentPosition() {
        return position;
    }

    public String name() { return name.get(); }

    public boolean isWinner(final Position position) {
        return this.position.equals(position);
    }

    public Position max(Position position) {
        if (this.position.isGreaterThan(position)) {
            return this.position;
        }

        return position;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name.get(), position);
    }
}
