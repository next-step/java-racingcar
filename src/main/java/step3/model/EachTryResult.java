package step3.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EachTryResult {

    private final Map<String, Integer> moveCountEach;

    public EachTryResult(Map<String, Integer> moveCountEach) {
        this.moveCountEach = moveCountEach;
    }

    public List<String> getWinnerNames() {
        int winnerMoveCount = calculateWinnerMoveCount();
        return getWinnerNames(winnerMoveCount);
    }

    private int calculateWinnerMoveCount() {
        return Collections.max(moveCountEach.values());
    }

    private List<String> getWinnerNames(int winnerMoveCount) {
        return moveCountEach.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(winnerMoveCount))
                .map(Map.Entry::getKey)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getMoveCountEach() {
        return moveCountEach;
    }
}
