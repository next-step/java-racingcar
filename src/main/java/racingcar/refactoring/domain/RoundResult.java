package racingcar.refactoring.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RoundResult {

    private Map<String, Integer> result;

    public RoundResult(Map<String, Integer> result) {
        this.result = result;
    }

    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return result.entrySet();
    }

    public List<String> findMaxPositionNames() {
        int maxPosition = Collections.max(result.values());
        return result.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
