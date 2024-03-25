package racing;

import java.util.Random;

public class Car {

    private static final int GO_CONDITION = 4;

    private int position = 1;
    private String name;

    public Car() {
    }

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= GO_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
