package racingcar.domain;

public class Car {
    private static final String CHECK_NAME_NULL = "이름 값이 null인지 확인해주세요.";
    private static final String CHECK_NAME_EMPTY = "이름 값이 공백인지 확인해주세요.";
    private static final String CHECK_NAME_LENGTH = "이름이 5자를 초과했는지 확인해주세요.";
    private static final String CHECK_RANDOM_NUMBER_BOUND = "이동 범위의 조건은 0 ~ 9이여야만 합니다.";
    private static final int INIT_VALUE = 0;
    private static final int CONDITION_FOR_MOVEMENT = 4;
    private static final int MAX_INCLUSIVE = 9;
    private static final int MIN_INCLUSIVE = 0;
    private static final int NAME_LENGTH_BOUND = 5;
    private int movementRange;
    private String name;

    public Car(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
        movementRange = INIT_VALUE;
    }

    public void move(int number) {
        validateRandomNumberBound(number);
        if (number >= CONDITION_FOR_MOVEMENT) {
            movementRange++;
        }
    }

    public void initializeMovementRange() {
        movementRange = INIT_VALUE;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public String getName() {
        return name;
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CHECK_NAME_EMPTY);
        }
    }

    private void validateLength(String name) {
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException(CHECK_NAME_LENGTH);
        }
    }

    private void validateRandomNumberBound(int randomNumber) {
        if (randomNumber > MAX_INCLUSIVE || randomNumber < MIN_INCLUSIVE) {
            throw new IllegalArgumentException(CHECK_RANDOM_NUMBER_BOUND);
        }
    }
}
