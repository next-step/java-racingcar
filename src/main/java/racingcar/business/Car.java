package racingcar.business;

import java.util.Objects;

public class Car {

    private DriveWay driveWay;
    private String name;
    private int totalDistance;

    private Car(final String name, final DriveWay driveWay) {
        this.name = name;
        this.totalDistance = 0;
        this.driveWay = driveWay;
    }

    public static Car of(final String name, final DriveWay driveWay) {
        return new Car(name, driveWay);
    }

    public String getName() {
        return this.name;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public void race() {
        if (driveWay.isEnableToMove()) {
            move();
        }
    }

    private void move() {
        this.totalDistance++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;

        return Objects.equals(name, car.name) &&
                totalDistance == car.totalDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalDistance);
    }
}
