package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceRecorder {

    private List<RaceRecord> records = new ArrayList<>();

    public void record(List<Car> cars) {
        records.add(new RaceRecord(cars));
    }

    public List<RaceRecord> getRecords() {
        return records;
    }
}
