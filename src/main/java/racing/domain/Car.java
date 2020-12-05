package racing.domain;

import java.util.Objects;

public class Car {

    private static final int INIT_LOCATION = 0;

    private final CarIndex carIndex;

    private final Location location;

    private Car(final CarIndex carIndex, final Location location) {
        this.carIndex = Objects.requireNonNull(carIndex);
        this.location = Objects.requireNonNull(location);
    }

    public static Car of(final int index) {
        return of(index, INIT_LOCATION);
    }

    public static Car of(final int index, final int location) {
        return of(CarIndex.valueOf(index), Location.valueOf(location));
    }

    public static Car of(final CarIndex carIndex, final Location location) {
        return new Car(carIndex, location);
    }

    public Car forward(final Moveable moveable) {
        return moveable.isMove() ? of(carIndex, location.forward()) : this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        final Car car = (Car) o;
        return Objects.equals(carIndex, car.carIndex) &&
                Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carIndex, location);
    }

    public CarReport report() {
        return CarReport.of(carIndex, location);
    }
}
