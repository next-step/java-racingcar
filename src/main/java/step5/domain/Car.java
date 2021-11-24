package step5.domain;


import step5.exception.RacingGameInputException;

import java.util.Objects;

public class Car {
    private final String name;
    private int currentPosition;

    public Car(String name) {
        exceptionExceeds5Letters(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public void move(int distance) {
        currentPosition += distance;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    private static void exceptionExceeds5Letters(String name) {
        if (name.length() > 5) {
            throw new RacingGameInputException("5자 이하의 자동차 이름을 입력하세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
