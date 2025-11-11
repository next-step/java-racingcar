package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private int position = 0;

    public void move() {
        position++;
    }

    public int position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= MOVE_THRESHOLD) {
            move();
        }
    }
}
