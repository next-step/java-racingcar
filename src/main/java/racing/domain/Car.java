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

    public void move(int number) {
        if (number >= Constant.GO_FORWARD_MIN_VALUE) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }
}
