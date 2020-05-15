package step3.racingcar;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private int position;
    private MovingStrategy movingStrategy;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Car(MovingStrategy movingStrategy) {
        this.position = DEFAULT_POSITION;
        this.movingStrategy = movingStrategy;
    }

    public void moveCarPosition() {
        boolean isMovable = this.movingStrategy.isMovable();
        if (isMovable == true)
            this.position++;
    }
}
