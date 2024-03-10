package racingcar;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private int position = 0;

    public void move(int random) {
        if (random >= ADVANCE_CONDITION_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
