package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResult {
    private final List<Record> record;

    public RaceResult() {
        this.record = new ArrayList<>();
    }

    public RaceResult(List<Record> record) {
        this.record = record;
    }

    public void addRecord(final Car car) {
        record.add(Record.record(car));
    }

    public List<Record> records() {
        return record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceResult result = (RaceResult) o;
        return Objects.equals(record, result.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record);
    }
}
