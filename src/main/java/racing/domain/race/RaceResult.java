package racing.domain.race;

import racing.domain.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<Record> records;

    public RaceResult() {
        this.records = new ArrayList<>();
    }

    public RaceResult(List<Record> record) {
        this.records = record;
    }

    public void addRecord(final Car car) {
        records.add(Record.record(car));
    }

    public List<Record> getRecords() {
        return records;
    }

    public List<Record> winners() {
        int location = getWinnersLocation();
        return getWinnerByLocation(location);
    }

    private int getWinnersLocation() {
        return records.stream()
            .mapToInt(Record::getLocation)
            .max()
            .orElseThrow(IllegalStateException::new);
    }

    private List<Record> getWinnerByLocation(final int location) {
        return records.stream()
            .filter(rcd -> rcd.getLocation() == location)
            .collect(Collectors.toUnmodifiableList());
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
        return Objects.equals(records, result.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(records);
    }
}
