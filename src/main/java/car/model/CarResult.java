package car.model;

import java.util.Objects;

public final class CarResult {

    private final String name;
    private final int position;

    public CarResult(final Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarResult carResult = (CarResult) o;
        return position == carResult.position && Objects.equals(name, carResult.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "CarResult{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}
