package racinggame.domain;

import racinggame.utils.StringUtils;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final String name;
    private Position position = new Position();

    public Car(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM)
            this.position = position.increase();
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
