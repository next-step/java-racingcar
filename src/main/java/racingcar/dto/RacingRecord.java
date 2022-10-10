package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private final List<CarsRecord> records;

    public RacingRecord() {
        this(new ArrayList<>());
    }

    public RacingRecord(List<CarsRecord> records) {
        this.records = records;
    }

    public void add(final CarsRecord carsRecord) {
        records.add(carsRecord);
    }

    public List<CarsRecord> getRecords() {
        return records;
    }
}
