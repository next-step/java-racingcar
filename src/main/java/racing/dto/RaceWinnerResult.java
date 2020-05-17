package racing.dto;

import racing.utils.EmptyCheckUtil;

import java.util.Collections;
import java.util.List;

public class RaceWinnerResult {
    private List<String> winnerNames;

    public RaceWinnerResult(List<String> winnerNames) {
        EmptyCheckUtil.emptyCheck(winnerNames);
        this.winnerNames = Collections.unmodifiableList(winnerNames);
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }
}
