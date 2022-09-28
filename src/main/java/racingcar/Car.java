package racingcar;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;
    private final String nickname;

    public Car(String nickname) {
        this.nickname = nickname;
    }

    public void move(Condition carCondition) {
        if (carCondition.inspect()) {
            this.position = position + 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.nickname;
    }
}
