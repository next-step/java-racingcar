package edu.nextstep.camp.racing.domain;

import java.util.Objects;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MOVING_MIN_VALUE = 4;
    private static final int MOVING_MAX_VALUE = 9 ;
    private final String name;

    private int position = 0;
    public Car(String name) {
        name = Objects.requireNonNull(name).trim();

        nameLengthCheck(name);

        this.name = name;
    }

    private static void nameLengthCheck(String carName) {
        if (carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없으며, 5자 이하로 작성 하세요");
        }
    }

    public void move(int randomInt) {
        if (MOVING_MAX_VALUE >= randomInt && randomInt >= MOVING_MIN_VALUE){
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }

    public int maxPosition(int comparePosition){
        return position - comparePosition;
    }

    public boolean isWinner(Car car){
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +" : "+ "-".repeat(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
