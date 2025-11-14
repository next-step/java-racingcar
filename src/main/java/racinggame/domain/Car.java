package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;
    public static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private static void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if (name.trim().length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        Random random = new Random();
        int randomNo = random.nextInt(MAX_BOUND);
        if (randomNo >= FORWARD_NUM)
            this.position++;
    }

    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            this.position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int max(int maxPosition) {
        return Math.max(this.position, maxPosition);
    }
}
