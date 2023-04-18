package entity.car;

import entity.NumberGenerator;

import java.util.Arrays;
import java.util.Random;

public class Car implements Comparable<Car>{

    private static final Random RANDOM_DICE = new Random();
    private static final int LEAST_RANDOM_VALUE = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private CarPosition position;
    private final CarName name;

    public Car(String name) {
        checkLengthOfCarName(name);
        checkNullOrBlank(name);
        this.position = new CarPosition(0);
        this.name = CarName.from(name);
    }

    public void moveCar(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= LEAST_RANDOM_VALUE) {
            this.position = position.move();
        }
    }

    private static void checkLengthOfCarName(String carNames) {
        if (carNames.length() > MAX_CAR_NAME_LENGTH)
            throw new IllegalArgumentException("차량 이름은 5글자를 초과 할 수 없습니다.");
    }

    private static void checkNullOrBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 null 이거나 빈 칸입니다.");
        }
    }

    public String getNameValue() {
        return name.getName();
    }

    public int getPositionValue() {
        return position.getPositionValue();
    }

    public int moveOrNot() {
        return RANDOM_DICE.nextInt(10);
    }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.getPositionValue(), o.getPositionValue());
    }
}
