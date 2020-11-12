package racing.domain;

import java.util.Objects;

import static racing.domain.CarConfig.*;

public class Car {

    private static final String CAR_NAME_VALIDATION_ERROR = "자동차 이름은 5자를 초과 할 수 없습니다";
    private final String name;
    private int position;

    public Car(String name) {
        this.name = carNameValidationCheck(name);
    }

    public Car(String name, int position) {
        this.name = carNameValidationCheck(name);
        this.position = position;
    }

    public Car move(RaceRule rule) {
        if(rule.movementRule()) {
            position++;
        }
        return new Car(name,position);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return position;
    }

    private String carNameValidationCheck(String name) {
        if(name.length() > CAR_NAME_LIMIT_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_VALIDATION_ERROR);
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
