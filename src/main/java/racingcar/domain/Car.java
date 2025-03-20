package racingcar.domain;

import java.util.Random;

import racingcar.exception.NameLengthException;

public class Car {
    private static final int MIN_MOVEMENT_THRESHOLD = 4;
    private static final int GO = 1;
    private static final int STOP = 0;
    public static final int START = 0;

    private final Random random = new Random();

    private int position;
    private final String name;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = START;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new NameLengthException("이름은 5자 이하만 가능합니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move() {
        if (getMovementStatus(generateRandomNumber()) == GO) {
            position += GO;
        }
    }

    private int getMovementStatus(int randomNumber) {
        if (randomNumber >= MIN_MOVEMENT_THRESHOLD) {
            return GO;
        }

        return STOP;
    }

    protected int generateRandomNumber() {
        return random.nextInt(10);
    }
}
