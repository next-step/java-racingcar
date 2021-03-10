package racingcar.domain;

public class Car {
    private static final int INIT_VALUE = 0;
    private static final int CONDITION_FOR_MOVEMENT = 4;
    private static final int MAX_INCLUSIVE = 9;
    private static final int MIN_INCLUSIVE = 0;
    private int movementRange;
    private String name;

    public Car() {
        movementRange = INIT_VALUE;
    }

    public void move(int number) {
        validateRandomNumber(number);
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

    public void setName(String name) {
        this.name = name;
    }

    private void validateRandomNumber(int randomNumber) {
        if (randomNumber > MAX_INCLUSIVE || randomNumber < MIN_INCLUSIVE) {
            throw new IllegalArgumentException("이동 범위의 조건은 0 ~ 9이여야만 합니다.");
        }
    }
}
