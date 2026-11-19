package racingcar;

public class CarMover {

    private static final int MOVABLE_THRESHOLD = 4;

    public void move(Car car, int number) {
        if (canMove(number)) {
            car.move();
        }
    }

    private boolean canMove(int number) {
        return number >= MOVABLE_THRESHOLD;
    }
}
