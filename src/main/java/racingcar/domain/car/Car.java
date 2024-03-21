package racingcar.domain.car;

import static racingcar.config.RacingCarException.CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH;
import static racingcar.config.RacingCarException.CAR_NAME_NOT_MATCHES_PATTERN;

import java.util.regex.Pattern;

import racingcar.domain.movement.MovementStrategy;

public class Car {

    public static final int SPEED = 1;
    private static final Pattern carNamePattern = Pattern.compile("^[a-z0-9]+$");
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    private Car(final String name) {
        this(name, START_POSITION);
    }

    private Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public Car copyOf() {
        return new Car(this.name, this.position);
    }

    public void moveForwardOrStop(final MovementStrategy movementStrategy) {
        if (movementStrategy.canMoveForward()) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position += SPEED;
    }

    public static Car from(final String name) {
        final String carName = name.trim();
        validateCarNameMatchesPattern(carName);
        validateCarNameIsNotLongerThanMaximumLength(carName);

        return new Car(carName);
    }

    private static void validateCarNameMatchesPattern(final String name) {
        if (notMatchesPattern(name)) {
            throw new IllegalArgumentException(CAR_NAME_NOT_MATCHES_PATTERN.message(name));
        }
    }

    private static boolean notMatchesPattern(final String name) {
        return !carNamePattern.matcher(name)
                .matches();
    }

    private static void validateCarNameIsNotLongerThanMaximumLength(final String name) {
        if (isLongerThanMaximumLength(name)) {
            throw new IllegalArgumentException(CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH.message(name));
        }
    }

    private static boolean isLongerThanMaximumLength(final String name) {
        return name.length() > CAR_NAME_MAXIMUM_LENGTH;
    }
}
