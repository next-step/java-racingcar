package vo;

import java.util.Objects;

public class CarRecord {

    private final String name;
    private final int distance;

    public CarRecord(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String name() {
        return this.name;
    }

    public int distance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRecord carRecord = (CarRecord) o;
        return distance == carRecord.distance && Objects.equals(name, carRecord.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
