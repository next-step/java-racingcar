package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RoundResult {

    private final Map<String, Integer> roundResult;

    public RoundResult(Map<String, Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return roundResult.entrySet();
    }

    public List<String> findWinners() {
        return roundResult.entrySet().stream()
                .filter(entry -> getMaxPosition() == entry.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Map.Entry<String, Integer> entry : getEntrySet()) {
            maxPosition = Math.max(maxPosition, entry.getValue());
        }
        return maxPosition;
    }
}
