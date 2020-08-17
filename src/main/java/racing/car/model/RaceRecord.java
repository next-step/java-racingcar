package racing.car.model;

import java.util.Map;

public class RaceRecord {

    private final int raceId;
    private final Map<String, Integer> trackRecords;

    private RaceRecord(int raceId, Map<String, Integer> trackRecords) {
        this.raceId = raceId;
        this.trackRecords = trackRecords;
    }

    public static RaceRecord of(int raceId, Cars cars) {
        Map<String, Integer> trackRecords = cars.getTrackRecords();

        return new RaceRecord(raceId, trackRecords);
    }

    public int getRaceId() {
        return raceId;
    }

    public Map<String, Integer> getTrackRecords() {
        return trackRecords;
    }

}
