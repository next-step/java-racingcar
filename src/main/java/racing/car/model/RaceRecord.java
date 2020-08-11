package racing.car.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceRecord {

    private final int raceId;
    private final Map<String, Integer> trackRecords;

    private RaceRecord(int raceId, Map<String, Integer> trackRecords) {
        this.raceId = raceId;
        this.trackRecords = trackRecords;
    }

    public static RaceRecord of(int raceId, List<Car> cars) {
        Map<String, Integer> trackRecords = new LinkedHashMap<>();
        for (Car car : cars) {
            trackRecords.put(car.getName(), car.getLocation());
        }

        return new RaceRecord(raceId, trackRecords);
    }

    public int getRaceId() {
        return raceId;
    }

    public Map<String, Integer> getTrackRecords() {
        return trackRecords;
    }

}
