package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<Record> winners() {
        int location = getWinnersLocation();
        return getWinnerByLocation(location);
    }

    private int getWinnersLocation() {
        return record.stream()
                .mapToInt(Record::getLocation)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    private List<Record> getWinnerByLocation(final int location){
        return record.stream()
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
        return Objects.equals(record, result.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record);
    }
}
