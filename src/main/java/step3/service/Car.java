package step3.service;

public class Car {
    private final Moving movingStrategy;
    private int moveCount = 0;

    public static Car randomMovingCar() {
        return new Car(new RandomMoving());
    }

    private Car(Moving movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.movable()) {
            moveCount++;
        }
    }
}
