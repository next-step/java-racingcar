package racinggame.domain;

import racinggame.utils.StringUtils;

public class Car {
    private static final int FORWARD_NUM = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int number) {
        if (number >= FORWARD_NUM) {
            position++;
        }
    }
}
