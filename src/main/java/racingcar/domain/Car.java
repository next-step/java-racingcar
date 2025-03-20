package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private Position position;
    private final Name name;

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(Position.of(0), Name.of(name));
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = this.position.plus();
        }
    }
}
