package racingcar.domain;

public class Car {
    private static final String CHECK_NAME_NULL = "이름 값이 null인지 확인해주세요.";
    private static final String CHECK_NAME_EMPTY = "이름 값이 공백인지 확인해주세요.";
    private static final String CHECK_RANDOM_NUMBER_BOUND = "이동 범위의 조건은 0 ~ 9이여야만 합니다.";
    private static final int INIT_VALUE = 0;
    private static final int CONDITION_FOR_MOVEMENT = 4;
    private static final int MAX_INCLUSIVE = 9;
    private static final int MIN_INCLUSIVE = 0;
    private int movementRange;
    private String name;

    public Car(String name) {
        validateNull(name);
        validateEmpty(name);
        this.name = name;
        movementRange = INIT_VALUE;
    }

    public void move(int number) {
        validateRandomNumberBound(number);
        if (number >= CONDITION_FOR_MOVEMENT) {
            movementRange++;
        }
    }

    public int getMovementRange() {
        return movementRange;
    }

    public String getName() {
        return name;
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CHECK_NAME_NULL);
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CHECK_NAME_EMPTY);
        }
    }

    private void validateRandomNumberBound(int randomNumber) {
        if (randomNumber > MAX_INCLUSIVE || randomNumber < MIN_INCLUSIVE) {
            throw new IllegalArgumentException(CHECK_RANDOM_NUMBER_BOUND);
        }
    }
}
