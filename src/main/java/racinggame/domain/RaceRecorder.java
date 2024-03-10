package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceRecorder {

    private List<RaceRecord> records = new ArrayList<>();

    public void record(List<Position> carsPositions) {
        records.add(new RaceRecord(carsPositions));
    }

    public List<RaceRecord> getRecords() {
        return records;
    }
}
