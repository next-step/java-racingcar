package racingcar.domain;

import racingcar.domain.movingcondition.MovingCondition;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
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

    public Name getName() {
        return name;
    }
}
