package racing.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoundRecord {

    private Map<String, Integer> positions;

    public RoundRecord() {
        this.positions = new HashMap<>();
    }

    public void addHistory(Car car) {
        this.positions.put(car.getName(), car.getPosition());
    }

    public Map<String, Integer> getPositions() {
        return Collections.unmodifiableMap(positions);
    }
}
