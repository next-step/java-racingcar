package racingcar;

public class Car {

    private int position = 0;

    private final MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public int moveIfPossible() {
        if (movableStrategy.isMovable()) {
            position++;
        }
        return position;
    }

}
