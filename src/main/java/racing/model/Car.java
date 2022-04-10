package racing.model;

public class Car {
    int moveCount = 0;

    public int run(CarMoveStrategy carMoveStrategy) {
        if (carMoveStrategy.isMovable()) {
            moveCount++;
        }
        return moveCount;
    }
}
