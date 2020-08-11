package racing.car.model;

import java.util.List;

public class RaceRecord {

    private final int raceId;
    private final List<Integer> trackRecords;

    public RaceRecord(int raceId, List<Integer> trackRecord) {
        this.raceId = raceId;
        this.trackRecords = trackRecord;
    }

    public int getRaceId() {
        return raceId;
    }

    public List<Integer> getTrackRecords() {
        return trackRecords;
    }

}
