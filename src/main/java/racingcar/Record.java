package racingcar;

import java.util.List;
import java.util.Map;

public class Record {
    private Map<Integer, List<Integer>> record;
    private Cars cars;

    public Record(Map<Integer, List<Integer>> record, Cars cars) {
        this.record = record;
        this.cars = cars;
    }
}
