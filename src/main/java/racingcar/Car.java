package racingcar;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private int position = 1;

    public void move(int number) {
        if (number >= ADVANCE_CONDITION_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
