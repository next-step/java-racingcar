package step3;

import java.util.Map;
import java.util.Set;

public class RoundResult {

    private final Map<String, Integer> roundResult;

    public RoundResult(Map<String, Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return roundResult.entrySet();
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Map.Entry<String, Integer> entry : getEntrySet()) {
            maxPosition = Math.max(maxPosition, entry.getValue());
        }
        return maxPosition;
    }
}
