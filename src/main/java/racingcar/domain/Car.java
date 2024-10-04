package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.Random;

public class Car {
    private static int MAX_LENGTH_OF_NAME = 5;
    private static int MIN_LENGTH_OF_NAME = 1;

    private int position;
    private String name;

    public Car(String name) {
        validateNameOfCar(name);
        this.name = name;
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
            position++;
        }
    }

    public boolean isSamePosition(int inputPosition) {
        return this.position == inputPosition;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return position;
    }
}