package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public void move(RandomValue randomValue) {
        if (randomValue.isMovable())
            this.position++;
    }

    public int maxPosition(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }
}
