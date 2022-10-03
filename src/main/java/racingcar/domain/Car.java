package racingcar.domain;

import racingcar.domain.movingcondition.MovingCondition;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position move(MovingCondition condition) {
        if (condition.canMove()) {
            position = position.add(1);
        }
        return position;
    }

    public boolean isWinner(Car other) {
        if (position.compareTo(other.position) >= 0) {
            return true;
        }
        return false;
    }

    public boolean isDraw(Car other) {
        return position.equals(other.position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
