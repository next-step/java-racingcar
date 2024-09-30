package racingcar;

public class Car {
    private static final int MIN_MOVABLE_CONDITION_NUMBER = 4;
    private int point;

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_CONDITION_NUMBER) {
            point++;
        }
    }

    public int getPoint() {
        return point;
    }
}
