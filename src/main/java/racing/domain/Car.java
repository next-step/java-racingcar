package racing.domain;

import java.util.Objects;

public class Car {

    private static final int INIT_LOCATION = 0;

    private final CarName carName;

    private final Location location;

    private Car(final CarName carName, final Location location) {
        this.carName = Objects.requireNonNull(carName);
        this.location = Objects.requireNonNull(location);
    }

    public static Car of(final String name) {
        return of(name, INIT_LOCATION);
    }

    public static Car of(final String name, final int location) {
        return of(CarName.of(name), Location.valueOf(location));
    }

    public static Car of(final CarName name, final Location location) {
        return new Car(name, location);
    }

    public Car forward(final Moveable moveable) {
        return moveable.isMove() ? of(carName, location.forward()) : this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        final Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, location);
    }

    public CarReport report() {
        return CarReport.of(carName, location);
    }
}
