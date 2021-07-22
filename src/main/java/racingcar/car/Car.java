package racingcar.car;

public class Car {

    private static final int MOVABLE_MINIMUM_NUMBER = 4;
    private int position;

    public void move(int number) {
        if (number >= MOVABLE_MINIMUM_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
