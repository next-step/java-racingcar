package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    private Position position;
    private Name name;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }
}
