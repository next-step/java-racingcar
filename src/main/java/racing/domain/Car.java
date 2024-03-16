package racing.domain;

import racing.Constant;
import racing.utils.ValidationUtil;

public class Car {
    private String name;
    private int position;

    public Car(final String name) {
        ValidationUtil.validateName(name);
        this.name = name;
        this.position = Constant.START_POSITION;
    }

    public Car(final String name, int position) {
        ValidationUtil.validateName(name);
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }

    public void move(int number) {
        if (number >= Constant.GO_FORWARD_MIN_VALUE) {
            position++;
        }
    }

    public int max(int other) {
        if (this.position > other) {
            return this.position;
        }
        return other;
    }

    public boolean isMatch(int maxPosition) {
        return this.position == maxPosition;
    }
}
