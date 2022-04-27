package core;

import java.util.Objects;

public class PositionTableKey {
    private final String id;
    private final CarName carName;

    private PositionTableKey(String id, CarName carName) {
        this.id = id;
        this.carName = carName;
    }

    public static PositionTableKey of(Car car) {
        return new PositionTableKey(car.getId(), car.getCarName());
    }

    public CarName getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionTableKey that = (PositionTableKey) o;
        return id.equals(that.id) && carName.equals(that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carName);
    }
}
