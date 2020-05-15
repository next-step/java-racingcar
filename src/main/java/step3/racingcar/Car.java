package step3.racingcar;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private int position;
    private MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.position = DEFAULT_POSITION;
        this.movingStrategy = movingStrategy;
    }

    public void startRacing() {
        boolean isMovable = this.movingStrategy.isMovable();
        if (isMovable == true)
            movePosition();
    }

    private void movePosition() {
        this.position++;
    }
}
