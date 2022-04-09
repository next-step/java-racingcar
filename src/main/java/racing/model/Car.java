package racing.model;

public class Car {
    final CarMoveStrategy carMoveStrategy;
    int moveCount = 0;

    public Car(CarMoveStrategy carMoveStrategy) {
        this.carMoveStrategy = carMoveStrategy;
    }

    public int run() {
        if (carMoveStrategy.isMovable()) {
            moveCount++;
        }
        return moveCount;
    }
}
