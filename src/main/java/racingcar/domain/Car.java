package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.regex.Pattern;

public class Car {

    private static final String CAR_NAME_NOT_MATCHES_PATTERN_MESSAGE = "자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다. [name : {0}]";
    private static final String CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다. [name : {0}]";
    private static final Pattern carNamePattern = Pattern.compile("^[a-z0-9]+$");
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
    private static final int START_POSITION = 0;
    private static final int SPEED = 1;

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
            throw new IllegalArgumentException(format(CAR_NAME_NOT_MATCHES_PATTERN_MESSAGE, name));
        }
    }

    private static boolean notMatchesPattern(final String name) {
        return !carNamePattern.matcher(name)
                .matches();
    }

    private static void validateCarNameIsNotLongerThanMaximumLength(final String name) {
        if (isLongerThanMaximumLength(name)) {
            throw new IllegalArgumentException(format(CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH_MESSAGE, name));
        }
    }

    private static boolean isLongerThanMaximumLength(final String name) {
        return name.length() > CAR_NAME_MAXIMUM_LENGTH;
    }
}
