package racingcar;

import racingcar.strategy.MovingStrategy;

public class Car {

    private final Position position;
    private final Name name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.shouldMove()) {
            position.move();
        }
    }

    public boolean isPositionEquals(Position position) {
        return this.position.equals(position);
    }

    public Position getBiggerPosition(Position position) {
        return this.position.getBigger(position);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public int getPositionValue() {
        return position.getPosition();
    }
}
