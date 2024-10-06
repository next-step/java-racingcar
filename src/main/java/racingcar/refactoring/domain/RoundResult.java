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

    public int findMaxValue() {
        return Collections.max(result.values());
    }

    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return result.entrySet();
    }

    public List<String> findKeysByValue(int value) {
        return result.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == value)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
}
