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

    public Car(final String name) {
        final String carName = name.trim();
        validateCarNameIsValid(carName);

        this.name = carName;
        this.position = START_POSITION;
    }

    private void validateCarNameIsValid(final String name) {
        validateCarNameMatchesPattern(name);
        validateCarNameIsNotLongerThanMaximumLength(name);
    }

    private void validateCarNameMatchesPattern(final String name) {
        if (notMatchesPattern(name)) {
            throw new IllegalArgumentException(format(CAR_NAME_NOT_MATCHES_PATTERN_MESSAGE, name));
        }
    }

    private boolean notMatchesPattern(final String name) {
        return !carNamePattern.matcher(name)
                .matches();
    }

    private void validateCarNameIsNotLongerThanMaximumLength(final String name) {
        if (isLongerThanMaximumLength(name)) {
            throw new IllegalArgumentException(format(CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH_MESSAGE, name));
        }
    }

    private boolean isLongerThanMaximumLength(final String name) {
        return name.length() > CAR_NAME_MAXIMUM_LENGTH;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public void moveForwardOrStop(final CarMovement carMovement) {
        if (carMovement.movable()) {
            moveForward();
        }
    }

    private void moveForward() {
        this.position += SPEED;
    }
}
