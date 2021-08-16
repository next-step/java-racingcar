package Car.domain;

public class Car {
    private MoveCount moveCount;
    private final CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.moveCount = new MoveCount();
    }

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = new CarName(carName);
        moveCount = new MoveCount(movingStrategy);
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getMoveCount() {
        return moveCount.getMoveCount();
    }

    public void move(int inputNumber) {
        moveCount = moveCount.move(inputNumber);
    }

}
