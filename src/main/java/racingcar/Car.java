package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private int position = 0;

    public int position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= MOVE_THRESHOLD) {
            move();
        }
    }

    private void move() {
        position++;
    }
}
