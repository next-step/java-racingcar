package step4.domain;

import step4.exception.ValidateBlankName;
import step4.exception.ValidateLengthOfCarName;

public class Car {
    private final static int LIMIT_LENGTH_CAR_NAME = 5;
    private int position;
    private String name;

    public Car(String name) {
        validateLengthOfCarName(name);
        validateBlankName(name);
        this.name = name;
        position = 0;
    }


    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position++;
        }

    }

    public int getPosition() {
        return this.position;
    }


    @Override
    public String toString() {
        return name;
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
}
