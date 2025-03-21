package racing.domain;

import java.util.Objects;
import java.util.function.BooleanSupplier;

import static racing.domain.CarFactory.randomMoveConditionSupplier;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private String name;

    private int position = 1;
    BooleanSupplier moveConditionSupplier;
    
    public Car(String name) {
        this(name, randomMoveConditionSupplier);
    }

    public Car(String name, BooleanSupplier moveConditionSupplier) {
        validateCarName(name);

        this.name = name;
        this.moveConditionSupplier = moveConditionSupplier;
    }

    private static boolean validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (this.moveConditionSupplier.getAsBoolean()) {
            this.position += 1;
        }
    }

    public int max(int other) {
        return Math.max(this.position, other);
    }

    public boolean isSamePosition(int other) {
        return this.position == other ? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name) && Objects.equals(moveConditionSupplier, car.moveConditionSupplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, moveConditionSupplier);
    }
}
