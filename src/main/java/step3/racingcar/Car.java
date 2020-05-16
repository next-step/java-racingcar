package step3.racingcar;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.position = DEFAULT_POSITION;
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar() {
        boolean isMovable = this.movingStrategy.isMovable();
        moveCarForward(isMovable);
    }

    public void moveCarForward(boolean isMovable) {
        if (isMovable == true)
            this.position++;
    }
}
