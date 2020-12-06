package racing.domain;

public class CarReport {

    private final int carIndex;

    private final int location;

    public CarReport(final int carIndex, final int location) {
        this.carIndex = carIndex;
        this.location = location;
    }

    public static CarReport of(final int index, final int location) {
        return new CarReport(index, location);
    }

    public static CarReport of(final CarIndex carIndex, final Location location) {
        return new CarReport(carIndex.getIndex(), location.getValue());
    }

    public int getLocation() {
        return location;
    }
}
