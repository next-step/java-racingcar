package racingcar.service.domain;

import racingcar.utils.RandomUtils;

public class Car {
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NUMBER = 10;

    private int id;
    private int position;

    public Car(int id) {
        this.id = id;
    }

    public void move() {
        if (checkCondition())
            position++;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return String.format("id : %d, position : %d", id, position);
    }

    private boolean checkCondition() {
        return MIN_NUMBER > RandomUtils.getRandomNumber(MAX_NUMBER);
    }
}
