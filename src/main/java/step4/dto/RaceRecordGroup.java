package step4.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceRecordGroup {
    private final int BEFORE_LAST_INDEX = 1;
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

    public List<CarName> findWinners() {
        return raceRecords.get(raceRecords.size() - BEFORE_LAST_INDEX).findWinners();
    }
}
