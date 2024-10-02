package racingcar.model;

public class Car {
    public static final int MOVE_CONDITION = 4;
    private int position;

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

    public int getMoveCount() {
        return position;
    }
}
