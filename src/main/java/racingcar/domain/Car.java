package racingcar.domain;

public class Car {
    private static final int THRESHOLD = 4;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            position++;
        }
    }
}
