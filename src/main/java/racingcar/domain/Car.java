package racingcar.domain;

public class Car {
    private static final int STANDARD_CAR_NAME_LENGTH = 5;
    private static final int INCREASE_STANDARD_NUMBER = 4;

    private String name;
    private int moveCount = 0;

    public Car(String carName) {
        if (carName.length() > STANDARD_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("Car name must be less than 6 characters.");
        }
        this.name = carName;
    }

    public void stopOrMove(int randomValue) {
        if (INCREASE_STANDARD_NUMBER <= randomValue) {
            moveCount += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
