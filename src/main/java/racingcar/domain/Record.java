package racingcar.domain;

import java.util.Objects;

public class Record {
    private final Cars record;

    public Record(final Cars cars) {
        this.record = new Cars(cars);
    }

    public Cars getRecord() {
        return this.record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record record1 = (Record) o;
        return Objects.equals(record, record1.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record);
    }
}
