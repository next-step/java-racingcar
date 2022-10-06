package racing.domain;

import java.util.Objects;

public class Record {
    private final String name;
    private final int location;

    public Record(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static Record record(final Car car) {
        return new Record(car.getName(), car.location());
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record record = (Record) o;
        return location == record.location && Objects.equals(name, record.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
