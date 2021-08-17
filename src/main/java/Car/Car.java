package Car;


import java.util.Random;


public class Car {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MAX_SIZE_NAME_LENGTH = 5;

    private int moveCount;
    private String carName;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int inputNumber) {
        if (inputNumber >= MIN_MOVE_NUMBER) {
            moveCount++;
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_SIZE_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_SIZE_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
