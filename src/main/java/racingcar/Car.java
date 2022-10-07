package racingcar;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private int position;

    public int position() {
        return position;
    }

    public void move(int number) {
        if (number >= AVAILABLE_MOVE_BOUND) {
            this.position += 1;
        }
    }
}
