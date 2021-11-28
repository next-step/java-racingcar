package step5.domain;

import step5.dto.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceRecordGroup {
    private static final int BEFORE_LAST_INDEX = 1;
    private final List<RaceRecord> raceRecords;

    public RaceRecordGroup() {
        this.raceRecords = new ArrayList<>();
    }

    public void addRaceRecord(RaceRecord raceRecord) {
        this.raceRecords.add(raceRecord);
    }

    public List<RaceRecord> getRaceRecordGroup() {
        return Collections.unmodifiableList(raceRecords);
    }

    public List<Car> findWinners() {
        return raceRecords.get(raceRecords.size() - BEFORE_LAST_INDEX).findWinners();
    }
}
