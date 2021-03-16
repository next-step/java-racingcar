package step3;

import java.util.function.Predicate;

public class Car {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private int currentPosition;
    private String carName;

    public Car(String carName) {
        if (carName == null || carName.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.currentPosition = 0;
        this.carName = carName;
    }

    public void moveForward(int number, Predicate<Integer> p) {
        if (p.test(number)) {
            currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public String getCarName() {
        return this.carName;
    }

    public boolean isWinner(int maxPosition) {
        return this.currentPosition == maxPosition;
    }

}
