package racing.domain;

public class CarReport {

    private final String name;

    private final int location;

    public CarReport(final String name, final int location) {
        this.name = name;
        this.location = location;
    }

    public static CarReport of(final String name, final int location) {
        return new CarReport(name, location);
    }

    public static CarReport of(final CarName name, final Location location) {
        return new CarReport(name.getValue(), location.getValue());
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public boolean isLocation(final int location) {
        return this.location == location;
    }
}
