package racing.car;

public class ReadOnlyCarProxy implements ReadonlyCar {

    private final String name;
    private final int location;

    public ReadOnlyCarProxy(ReadonlyCar car) {
        this.name = car.getName();
        this.location = car.getLocation();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLocation() {
        return location;
    }
}
