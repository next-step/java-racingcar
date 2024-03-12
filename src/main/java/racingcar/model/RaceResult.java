package racingcar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RaceResult implements Iterable<DistanceRecord> {
    private final Map<Integer, DistanceRecord> resultMap;

    public RaceResult() {
        this.resultMap = new HashMap<>();
    }

    public void recordRaceResult(int tryNumber, DistanceRecord distanceRecord) {
        resultMap.put(tryNumber, distanceRecord);
    }

    @Override
    public Iterator<DistanceRecord> iterator() {
        return resultMap.values().iterator();
    }
}
