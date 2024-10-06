package racingcar.refactoring.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final List<Map<String, Integer>> roundResults;

    public GameResult(List<Map<String, Integer>> roundResults) {
        this.roundResults = roundResults;
    }

    public List<Map<String, Integer>> getRoundResults() {
        return roundResults;
    }

    public List<String> findWinners() {
        return createWinnersName();
    }

    private List<String> createWinnersName() {
        int maxPosition = getMaxPosition();
        List<String> winnersName = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : getLastRoundResult().entrySet()) {
            isWinner(entry.getValue(), maxPosition, entry.getKey(), winnersName);
        }
        return winnersName;
    }

    private void isWinner(int position, int maxPosition, String name, List<String> winnersName) {
        if (position == maxPosition) {
            winnersName.add(name);
        }
    }

    private int getMaxPosition() {
        return Collections.max(getLastRoundResult().values());
    }

    private Map<String, Integer> getLastRoundResult() {
        return roundResults.get(roundResults.size() - 1);
    }
}
