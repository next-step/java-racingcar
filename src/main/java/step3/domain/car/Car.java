package step3.domain.car;

import step3.domain.board.RoundBoard;

import java.util.Objects;

import static step3.utils.ValidationUtils.checkArgument;

public class Car {

    private static final int POWER_BOUND = 4;
    private final Location location;

    public Car(Location location) {
        checkArgument(location != null, "location is Required");
        this.location = location;
    }

    public void go(Integer power) {
        validatePower(power);
        if (power >= POWER_BOUND) {
            location.goForward();
        }
    }

    private void validatePower(Integer power) {
        checkArgument(power != null, "power is Required");
        checkArgument(power >= 0 && power <= 9, "power의 범위는 0 - 9 이어야 합니다.");
    }

    public void record(RoundBoard roundBoard) {
        location.record(roundBoard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return "Car{" +
                "location=" + location +
                '}';
    }
}
