package racingcar.car;

public class Car {
    private int position;

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
