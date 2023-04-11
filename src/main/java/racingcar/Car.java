package racingcar;

public class Car {

    private static final int MOVABLE_COUNT = 4;
    private int position;

    public void move(int number) {
        if (movable(number)) {
            position++;
        }
    }

    private boolean movable(int number) {
        return number >= MOVABLE_COUNT;
    }

    public int getPosition() {
        return position;
    }
}
