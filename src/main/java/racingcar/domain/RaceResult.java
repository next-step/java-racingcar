package racingcar.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RaceResult implements Iterable<CarRecords> {
    private final Map<Integer, CarRecords> resultMap;

    public RaceResult() {
        this.resultMap = new HashMap<>();
    }

    public void recordRaceResult(int tryNumber, CarRecords carRecords) {
        resultMap.put(tryNumber, carRecords);
    }

    @Override
    public Iterator<CarRecords> iterator() {
        return resultMap.values().iterator();
    }
}
