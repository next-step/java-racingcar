package racingcar.domain;

public class Car {
    private int position = 0;
    private static final int MAX_FORWARD_NUMBER = 4;

    public void move(int randomNo) {
        if (randomNo >= MAX_FORWARD_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
