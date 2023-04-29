package racingcar.domain;

public class Car {

    private int moveCount = 0;
    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public CarName getCarName() {
        return this.carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            moveCount++;
        }
    }
}