package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceRecords {

    private final List<RaceRecord> values;

    public RaceRecords(List<RaceRecord> values) {
        this.values = new ArrayList<>(values);
    }

    public static RaceRecords init(Cars cars) {
        return new RaceRecords(List.of(new RaceRecord(cars)));
    }

    public void record(int sequence, Cars cars) {
        this.values.add(new RaceRecord(sequence, cars));
    }

    public List<RaceRecord> getValues() {
        return this.values;
    }
}
