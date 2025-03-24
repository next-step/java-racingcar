package racing.domain;

import java.util.Objects;
import java.util.function.BooleanSupplier;

import static racing.domain.CarFactory.randomMoveConditionSupplier;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private String name;

    private Position position;
    private BooleanSupplier moveConditionSupplier;
    
    public Car(String name) {
        this(name, randomMoveConditionSupplier);
    }

    public Car(String name, BooleanSupplier moveConditionSupplier) {
        validateCarNameOrThrow(name);

        this.name = name;
        this.moveConditionSupplier = moveConditionSupplier;
        this.position = new Position(1);
    }

    private void validateCarNameOrThrow(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPositionForDisplay();
    }

    public void move() {
        if (this.moveConditionSupplier.getAsBoolean()) {
            this.position.increase();
            System.out.println(this.name + " : move! position : " + this.position.getPositionForDisplay());
        } else {
            System.out.println(this.name + " : DON'T move! position : " + this.position.getPositionForDisplay());
        }
    }

    public int max(int other) {
        return position.max(other);
    }

    public boolean isSamePosition(int other) {
        return this.position.isSamePosition(other);
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
