package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class CarRecord{
    private final Map<String, Integer> carRecord;

    public CarRecord() {
        this.carRecord = new HashMap<>();
    }

    public void put(String carName, Integer distance) {
        this.carRecord.put(carName, distance);
    }

    public Integer getDistance(String carName) {
        return this.carRecord.get(carName);
    }

    public int size() {
        return this.carRecord.size();
    }
}
