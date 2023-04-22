package step3.domain;

import java.io.Serializable;

public class Car implements Serializable {
    private static final int MOVE_NUMBER = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int START_LOCATION = 0;
    private static final String DEFAULT_CAR_NAME = "benz";
    private int location;
    private CarName carName;

    public Car() {
        this(DEFAULT_CAR_NAME);
    }

    public Car(String carName) {
        this.location = START_LOCATION;
        this.carName = new CarName(carName);
    }

    public void move(int input) {
        if (isMovable(input)) {
            this.location++;
        }
    }

    private boolean isMovable(int input) {
        if (input < MIN_NUMBER || input > MAX_NUMBER) {
            throw new RuntimeException("유효하지 않은 숫자입니다.");
        }
        return input >= MOVE_NUMBER;
    }

    public int location() {
        return location;
    }

    public boolean isWinner(int highScore) {
        return location == highScore;
    }

    public String name() {
        return carName.value();
    }
}
