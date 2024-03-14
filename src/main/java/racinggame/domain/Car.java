package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    private final String name;

    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    Car(final String name, int position) {
        this(name, new Position(position));
    }

    Car(final String name, Position position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            this.position.increase();
    }

    public int max(int other) {
        return this.position.max(other);
    }

    public boolean isMatch(int maxPosition) {
        return this.position.isMatch(maxPosition);
    }
}
