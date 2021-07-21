package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    private Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public static Car newInstance() {
        return new Car("");
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public int currentPosition() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(MoveStrategy moveStrategy) {
        validate(moveStrategy);

        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    private void validate(MoveStrategy moveStrategy) {
        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("MoveStrategy can't be null");
        }
    }
}
