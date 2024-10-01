package racingcar;

public class Car {
    private static final int MIN_MOVABLE_CONDITION_NUMBER = 4;
    private int position = 0;

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_CONDITION_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
