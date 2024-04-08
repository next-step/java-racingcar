package racingcar.domain;

import java.util.Objects;

public class CarLocation {
    private int location;

    public CarLocation() {
        this.location = 0;
    }

    public CarLocation(int location) {
        this.location = location;
    }

    public void increase() {
        location++;
    }

    public boolean isMaxLocation(int max) {
        return this.location == max;
    }

    public int checkMaxLocation(int carLocation) {
        return Math.max(this.location, carLocation);
    }

    public int getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLocation that = (CarLocation) o;
        return location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
