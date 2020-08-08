package racing.model;

import java.util.List;

public class RaceRecord {

    private final int raceId;
    private final List<Integer> trackRecord;

    public RaceRecord(int raceId, List<Integer> trackRecord) {
        this.raceId = raceId;
        this.trackRecord = trackRecord;
    }

    public int getRaceId() {
        return raceId;
    }

    public List<Integer> getTrackRecord() {
        return trackRecord;
    }

}
