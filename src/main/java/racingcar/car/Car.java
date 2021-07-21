package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private int position;

    private Car() {
        this.position = 0;
    }

    public static Car newInstance() {
        return new Car();
    }

    public int currentPosition() {
        return position;
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
