package racingcar.car;

import java.util.Objects;

public class NextStepCar implements Car {
    private final String name;
    private int position;

    public NextStepCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name length must be lower than 5");
        }
        this.name = carName;
        this.position = 0;
    }

    @Override
    public int moveForward(int randomNumber) {
        return (randomNumber >= 4) ? ++position : position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NextStepCar that = (NextStepCar) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
