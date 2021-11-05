package step3.domain.car;

import java.util.Objects;

import static step3.utils.ValidationUtils.checkArgument;

public class Car {

    private final int powerBound;
    private final Location location;

    public Car(Integer powerBound, Location location) {
        checkArgument(powerBound != null, "powerBound is Required");
        checkArgument(location != null, "location is Required");
        this.powerBound = powerBound;
        this.location = location;
    }

    public void go(Integer power) {
        validatePower(power);
        if (power >= powerBound) {
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
        return powerBound == car.powerBound && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerBound, location);
    }

    @Override
    public String toString() {
        return "Car{" +
                "powerBound=" + powerBound +
                ", location=" + location +
                '}';
    }
}
