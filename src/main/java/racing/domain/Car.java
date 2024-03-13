package racing.domain;

import racing.Constant;

public class Car {
    private int position;

    public Car() {
        this.position = Constant.START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= Constant.GO_FORWARD_MIN_VALUE) {
            position++;
        }
    }
}
