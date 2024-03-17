package racingCar;

import java.util.Objects;

public class RacingCar {

    private CarName name;
    private Location location;

    public RacingCar() {
        this.location = new Location();
    }

    public RacingCar(CarName name) {
        this.name = name;
        this.location = new Location();
    }

    public RacingCar(CarName name, Location location) {
        this.name = name;
        this.location = location;
    }

    public int findCurrentLocation() {
        return this.location.getLocation();
    }

    public boolean isSameLocation(int location) {
        return findCurrentLocation() == location;
    }

    public int compareMaxDistance(int distance) {
        return Math.max(findCurrentLocation(), distance);
    }

    public String findCarName() {
        return this.name.getName();
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.location.increase();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(findCarName())
            .append(" : ")
            .append("-".repeat(Math.max(0, location.getLocation())))
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(location,
            racingCar.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
