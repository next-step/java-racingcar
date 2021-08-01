package Car;

public class Car {
    private static final int MIN_MOVE_NUMBER = 4;

    private int moveCount;
    private String carName;

    public String getCarName() {
        return carName;
    }

    public Car(String carName) {
        moveCount = 0;
        this.carName = carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(int inputNumber) {
        if (inputNumber >= MIN_MOVE_NUMBER) {
            moveCount++;
        }
    }
}
