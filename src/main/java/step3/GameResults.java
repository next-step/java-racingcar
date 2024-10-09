package step3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResults {

    public static final String NAME_DELIMITER = ",";
    private final List<RoundResult> gameResults;

    public GameResults(List<RoundResult> gameResults) {
        this.gameResults = gameResults;
    }

    public int getSize() {
        return gameResults.size();
    }

    public RoundResult getRoundResult(int index) {
        return gameResults.get(index);
    }

    public String getWinners() {
        RoundResult finalResult = getRoundResult(getSize() - 1);
        return finalResult.getEntrySet().stream()
                .filter(entry -> finalResult.getMaxPosition() == entry.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(NAME_DELIMITER));
    }
}
