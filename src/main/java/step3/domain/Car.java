package step3.domain;

import java.util.function.Predicate;

public class Car {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private int currentPosition;
    private final String carName;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        if (carName == null || carName.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.currentPosition = position;
        this.carName = carName;
    }

    public void moveForward(int number, Predicate<Integer> p) {
        if (p.test(number)) {
            this.currentPosition++;
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
