package racingcar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RaceResult implements Iterable<CarRecord> {
    private final Map<Integer, CarRecord> resultMap;

    public RaceResult() {
        this.resultMap = new HashMap<>();
    }

    public void recordRaceResult(int tryNumber, CarRecord carRecord) {
        resultMap.put(tryNumber, carRecord);
    }

    public CarRecord getFinalRaceResult() {
        return this.resultMap.get(this.resultMap.size()-1);
    }

    @Override
    public Iterator<CarRecord> iterator() {
        return resultMap.values().iterator();
    }
}
