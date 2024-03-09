package model;

import java.util.Objects;

public class Record {
    private final int position;

    public Record(int position) {
        this.position = position;
    }

    public Record(Car car) {
        this.position = car.getPosition();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return position == record.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
