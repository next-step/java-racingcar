package racing.car;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReadOnlyCarProxy)) return false;
        ReadOnlyCarProxy that = (ReadOnlyCarProxy) o;
        return getLocation() == that.getLocation() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }
}
