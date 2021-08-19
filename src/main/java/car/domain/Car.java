package car.domain;

public class Car {
    private MoveCount moveCount;
    private final CarName carName;
    private final MovingStrategy movingStrategy;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.moveCount = new MoveCount();
        this.movingStrategy = new DefaultStrategy();
    }

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = new CarName(carName);
        moveCount = new MoveCount();
        this.movingStrategy = movingStrategy;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getMoveCount() {
        return moveCount.getMoveCount();
    }

    public void move(int inputNumber) {
        if (movingStrategy.isMovable(inputNumber)) {
            moveCount = moveCount.move();
        }
    }

}
