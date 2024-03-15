package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {

    private static final String CAR_NUMBER_OUT_OF_RANGE_MESSAGE = "자동차의 번호는 자연수만 가능합니다. [number : {0}]";
    private static final String CAR_NAME_NOT_MATCHES_PATTERN_MESSAGE = "자동차의 이름은 한 글자 이상의 영어 소문자와 숫자만 가능합니다. [name : {0}]";
    private static final String CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다. [name : {0}]";
    private static final Pattern carNamePattern = Pattern.compile("^[a-z0-9]+$");
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
    private static final int START_POSITION = 0;
    private static final int MINIMUM_CAR_NUMBER = 1;
    private static final int SPEED = 1;

    private String name;
    private int number;
    private int position;

    public Car(final int number) {
        validateCarNumberIsInRange(number);

        this.number = number;
        this.position = START_POSITION;
    }

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
        final Matcher matcher = carNamePattern.matcher(name);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(format(CAR_NAME_NOT_MATCHES_PATTERN_MESSAGE, name));
        }
    }

    private void validateCarNameIsNotLongerThanMaximumLength(final String name) {
        if (name.length() > CAR_NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(format(CAR_NAME_LONGER_THAN_MAXIMUM_LENGTH_MESSAGE, name));
        }
    }

    private void validateCarNumberIsInRange(final int number) {
        if (isCarNumberOutOfRange(number)) {
            throw new IllegalArgumentException(format(CAR_NUMBER_OUT_OF_RANGE_MESSAGE, number));
        }
    }

    private boolean isCarNumberOutOfRange(final int number) {
        return number < MINIMUM_CAR_NUMBER;
    }

    public int number() {
        return this.number;
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
