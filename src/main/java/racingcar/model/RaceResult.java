package racingcar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RaceResult implements Iterable<List<Integer>> {
    private final Map<Integer, List<Integer>> resultMap;

    public RaceResult() {
        this.resultMap = new HashMap<>();
    }

    public void recordRaceResult(int tryNumber, List<Integer> distanceRecord) {
        resultMap.put(tryNumber, distanceRecord);
    }

    @Override
    public Iterator<List<Integer>> iterator() {
        return resultMap.values().iterator();
    }
}
