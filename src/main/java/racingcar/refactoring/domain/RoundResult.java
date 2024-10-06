package racingcar.refactoring.domain;

import java.util.*;

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
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() == value) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
