package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.Random;

public class Car {
    private static int MAX_LENGTH_OF_NAME = 5;
    private static int MIN_LENGTH_OF_NAME = 1;

    private Position position;
    private String name;

    public Car(String name) {
        validateNameOfCar(name);
        this.name = name;
        this.position = new Position(0);
    }

    private void validateNameOfCar(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 명이 비어 있습니다.");
        }
        if (name.length() < MIN_LENGTH_OF_NAME || name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 명은 최소1글자, 최대5글자로 제한합니다.");
        }
    }

    public void run(boolean isMove) {
        if (isMove) {
            position.add();
        }
    }

    public int max(int inputMax) {
        return position.max(inputMax);
    }

    public boolean isSamePosition(int inputPosition) {
        return position.isSamePosition(inputPosition);
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return position.getValue();
    }
}