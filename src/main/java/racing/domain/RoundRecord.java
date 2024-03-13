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

    public void addHistory(Car car) {
        this.positions.put(car.getName(), car.getPosition());
    }

    public Map<String, Integer> getPositions() {
        return Collections.unmodifiableMap(positions);
    }

    public List<String> findMaxPosition() {
//        // 최대값 찾기
//        int maxValue = this.positions.values().stream()
//                .max(Integer::compareTo)
//                //.max((a,b) -> a.compareTo(b))
//                .orElse(0);
//
//        // 최대값을 가진 키 찾기
//        return this.positions.entrySet().stream()
//                .filter(position -> position.getValue() == maxValue)
//                .map(Map.Entry::getKey)
//                //.map(i -> i.getKey())
//                .collect(Collectors.toList());

        return this.positions.entrySet().stream()
                .filter(i -> i.getValue().equals(getMaxPosition()))
                //.map(i-> i.getKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Integer getMaxPosition() {
        return Collections.max(this.positions.values());
    }
}
