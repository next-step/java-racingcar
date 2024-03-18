package racing.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoundRecord {

    private Map<String, Integer> positions;

    public RoundRecord() {
        this.positions = new HashMap<>();
    }

    public RoundRecord(Map<String, Integer> positions) {
        this.positions = positions;
    }

    public void addHistory(Car car) {
        this.positions.put(car.getName(), car.getPosition());
    }

    public Map<String, Integer> getPositions() {
        return Collections.unmodifiableMap(positions);
    }

    public List<String> findMaxPosition() {

        return this.positions.entrySet().stream()
                .filter(i -> i.getValue().equals(getMaxPosition()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Integer getMaxPosition() {
        return Collections.max(this.positions.values());
    }
}
