package step5.domain;

import step5.exception.ValidateBlankName;
import step5.exception.ValidateLengthOfCarName;

public class Car {
    private final static int LIMIT_LENGTH_CAR_NAME = 5;
    private final static int MIN_MOVE_CONDITION = 4;
    private int position;
    private final String name;

    public Car(String name) {
        validateLengthOfCarName(name);
        validateBlankName(name);
        this.name = name;
        position = 0;
    }


    public void move(int moveCondition) {
        if (moveCondition >= MIN_MOVE_CONDITION) {
            position++;
        }

    }

    public int getPosition() {
        return this.position;
    }



    private void validateLengthOfCarName(String name) {
        if (name.length() > LIMIT_LENGTH_CAR_NAME) {
            throw new ValidateLengthOfCarName(LIMIT_LENGTH_CAR_NAME);
        }
    }

    private void validateBlankName(String name) {
        if (name.trim().length() == 0) {
            throw new ValidateBlankName();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
