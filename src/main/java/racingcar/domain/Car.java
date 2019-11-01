package racingcar.domain;

import java.util.Objects;

public class Car {

    private final String name;
    private int distance;
    private final DriveWay driveWay;

    Car(final String name, final DriveWay driveWay) {
        this.name = name;
        this.distance = 0;
        this.driveWay = driveWay;
    }

    void race() {
        if (driveWay.isEnableToMove()) {
            this.distance++;
        }
    }

    int findMaxDistance(final int maxDistance) {
        return Math.max(this.distance, maxDistance);
    }

    boolean isWinner(final int maxDistance) {
        return this.distance == maxDistance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
