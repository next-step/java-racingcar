package racewinner.domain;

import racewinner.domain.strategy.MoveStrategy;

public class Car {
    private final Name name;
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.position = new Position(0);
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

    public boolean isMaxPosition(final Position position) {
        return this.position.isGreaterThan(position);
    }

    public boolean isWinner(final Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name.get(), position);
    }
}
