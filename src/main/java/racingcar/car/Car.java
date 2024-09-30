package racingcar.car;

public class Car {
    private static final int ALLOWED_MINIMUM_DISTANCE = 4;
    private static final int DEFAULT_POSITION = 0;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            this.position += 1;
        }
    }

    private boolean canMove(int distance) {
        return distance >= ALLOWED_MINIMUM_DISTANCE;
    }

    public int getPosition() {
        return position;
    }
}
