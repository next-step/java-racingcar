package racingCar;

import racingCar.utils.NumberUtils;

public class Car {
    private static final int COMPARE_VALUE = 4;
    private static final int MAX_NAME_LENGTH = 4;

    private String name;
    private int moveCount = 0;

    Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5글자 미만으로 정해주세요.");
        }
        this.name = name;
    }

    public void move() {
        if (NumberUtils.getRandomNumber() >= COMPARE_VALUE) {
            moveCount += 1;
        }
    }

    public String getName() {
        return name + " : ";
    }

    public int getMoveCount() {
        return moveCount;
    }
}
