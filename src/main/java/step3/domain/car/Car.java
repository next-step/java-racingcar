package step3.domain.car;

import step3.domain.board.CarSnapshot;

import java.util.Objects;

import static java.lang.String.format;
import static step3.utils.ValidationUtils.checkArgument;

public class Car implements Comparable<Car> {

    private static final int POWER_BOUND = 4;
    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;
    private static final String DEFAULT_NAME = "기본이름";

    static final String POWER_OUT_OF_RANGE_ERROR_MESSAGE = format("power의 범위는 %s - %s 이어야 합니다.", MIN_POWER, MAX_POWER);

    private final Location location;
    private final Name name;

    public Car(Location location) {
        checkArgument(location != null, "location is Required");
        this.location = location;
        this.name = new Name(DEFAULT_NAME);
    }

    public Car(Location location, Name name) {
        checkArguments(location, name);
        this.location = location;
        this.name = name;
    }

    private void checkArguments(Location location, Name name) {
        checkArgument(location != null, "location is Required");
        checkArgument(name != null, "name is Required");
    }

    public CarSnapshot go(Integer power) {
        validatePower(power);
        if (power >= POWER_BOUND) {
            location.goForward();
        }
        return new CarSnapshot(location.copy(), name);
    }

    private void validatePower(Integer power) {
        checkArgument(power != null, "power is Required");
        checkArgument(power >= MIN_POWER && power <= MAX_POWER, POWER_OUT_OF_RANGE_ERROR_MESSAGE);
    }

    public boolean locationEquals(Location winnerLocation) {
        return location.equals(winnerLocation);
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(Car other) {
        if (other == null) {
            return 0;
        }
        return location.compareTo(other.location);
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
