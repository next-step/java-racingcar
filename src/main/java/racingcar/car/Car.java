package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private int position;
    private final MoveStrategy moveStrategy;

    private Car(MoveStrategy moveStrategy) {
        validate(moveStrategy);

        this.moveStrategy = moveStrategy;
    }

    public static Car from(MoveStrategy moveStrategy) {
        return new Car(moveStrategy);
    }

    private void validate(MoveStrategy moveStrategy) {
        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("MoveStrategy can't be a null");
        }
    }

    public int currentPosition() {
        return position;
    }

    // move(MoveStrategy moveStrategy); 같은 방식은 어떨까..?
    public void move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }
}
