package racing.domain;

import java.util.Objects;

public class CarReport {

    private final CarIndex carIndex;

    private final Location location;

    private CarReport(final CarIndex carIndex, final Location location) {
        this.carIndex = Objects.requireNonNull(carIndex);
        this.location = Objects.requireNonNull(location);
    }

    public static CarReport of(final int index, final int location) {
        return of(CarIndex.valueOf(index), Location.valueOf(location));
    }

    public static CarReport of(final CarIndex carIndex, final Location location) {
        return new CarReport(carIndex, location);
    }
}
