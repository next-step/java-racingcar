package racingcar.domain;

import racingcar.exception.InvalidNameException;
import racingcar.exception.NameLengthException;

public class Car {
    private static final int MIN_MOVEMENT_THRESHOLD = 4;
    private static final int GO = 1;
    private static final int START = 0;

    private int position;
    private final String name;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = START;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new InvalidNameException("이름은 null 이 올 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new NameLengthException("이름은 5자 이하만 가능합니다.");
        }

        if (name.trim().isEmpty()) {
            throw new InvalidNameException("자동차 이름은 공백이 될 수 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if (getMovementStatus(randomNumber)) {
            position += GO;
        }
    }

    private boolean getMovementStatus(int randomNumber) {
        return randomNumber >= MIN_MOVEMENT_THRESHOLD;
    }
}
