package racingcar.car;

import calculator.utils.StringUtils;
import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private static final int NAME_LIMIT = 5;
    private static final int STARTING_POSITION = 0;

    private final String name;
    private int position;

    private Car(String name) {
        validate(name);

        this.position = STARTING_POSITION;
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Car name can't be null or empty value");
        }

        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("Car name must equal or less than " + NAME_LIMIT);
        }
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

    public boolean isSamePosition(int comparePosition) {
        return currentPosition() == comparePosition;
    }
}
